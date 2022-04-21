package Model;

import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.events.GameEvent;
import Model.events.GameListener;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.units.Ball;

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

        // "Наблюдаем" за событиями, связанными с движениями шариков
        for (Ball ball: _field.balls()) {
            ball.addBallActionListener(new BallObserver());
        }
    }

    private GameField constructLevel() {
        return _map.createField().seedBalls().seedBarriers().seedGoals().build();
    }


    // ------------------------- Реагируем на действия Шарика ------------------

    private class BallObserver implements BallActionListener {

        @Override
        public void ballHasMoved(BallActionEvent e) {
            if(e.ball().getOwner() == null) {
                _field.deleteBall(e.ball());
            }

            if (_field.balls().isEmpty()) {
                fireGameFinished();
            }

            fireBallHasMoved(e.ball());
        }

        @Override
        public void ballHasAStep(BallActionEvent e) {
            fireBallHasAStep(e.ball());
        }
    }


// ------------------------ Порождает события игры ----------------------------

    private ArrayList _listeners = new ArrayList();

    public void addGameListener(GameListener l) {
        _listeners.add(l);
    }

    public void removeGameListener(GameListener l) {
        _listeners.remove(l);
    }

    protected void fireGameFinished() {

        GameEvent event = new GameEvent(this);

        for (Object listener: _listeners) {
            ((GameListener)listener).gameFinished(event);
        }
    }


// ------------------ Порождает события, связанные с движением Шариков ---------------------

    private List<BallActionListener> _ballListeners = new ArrayList<>();

    public void addBallActionListener(BallActionListener listener) {
        _ballListeners.add(listener);
    }

    public void removeBallActionListener(BallActionListener listener) {
        _ballListeners.remove(listener);
    }

    protected void fireBallHasMoved(Ball ball) {

        BallActionEvent event = new BallActionEvent(ball);
        event.setBall(ball);
        for (Object listener: _ballListeners) {
            ((BallActionListener)listener).ballHasMoved(event);
        }
    }

    protected void fireBallHasAStep(Ball ball) {
        BallActionEvent event = new BallActionEvent(ball);
        event.setBall(ball);
        for (Object listener: _ballListeners) {
            ((BallActionListener)listener).ballHasAStep(event);
        }
    }
}


