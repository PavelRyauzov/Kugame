package Model;

import Model.events.*;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.units.AbstractGoal;
import Model.units.Ball;
import Model.units.MulticoloredGoal;
import Model.units.SingleColoredGoal;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private GameField _field;

    public GameField field() { return _field; }

    private GameMap _map;

    public Game(GameMap map) {
        super();
        _map = map;
        if (_map == null) {
            throw new IllegalArgumentException("Game can't work without Map!");
        }
    }

    public void start() {

        _field = constructLevel();

        // Связываем слушателей событий в виде ворот и источников событий в виде Шариков
        for (AbstractGoal goal: _field.goals()) {
            for (Ball ball: _field.balls()) {
                ball.ballActionCreator().addBallActionListener(new BallObserver(goal));
            }
        }

        // Связываем слушателей событий в виде игры и источников событий в виде Шариков
        for (Ball ball: _field.balls()) {
            ball.ballActionCreator().addBallActionListener(new BallObserver(this));
        }
    }

    private GameField constructLevel() {
        return _map.createField().seedBalls().seedBarriers().seedGoals().build();
    }

// ------------------------ Порождает события игры ----------------------------

    private ArrayList _listeners = new ArrayList();

    public void addGameListener(GameListener l) {
        _listeners.add(l);
    }

    public void removeGameListener(GameListener l) {
        _listeners.remove(l);
    }

    public void fireGameFinished() {

        GameEvent event = new GameEvent(this);

        for (Object listener: _listeners) {
            ((GameListener)listener).gameFinished(event);
        }
    }


// ------------------ Порождает события, связанные с движением Шариков ---------------------
    private BallActionCreator _ballActionCreator = new BallActionCreator();
    public BallActionCreator ballActionCreator() { return _ballActionCreator; }
}


