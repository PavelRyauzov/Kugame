package Model;

import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.units.Ball;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private GameField _field;
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

        // "Наблюдаем" за событиями, связанные с действием шариков
        for (Ball ball: _field.balls()) {
            ball.addBallActionListener(new BallObserver());
        }
    }

    private GameField constructLevel() {
        return _map.createField().seedBalls().seedBarriers().seedGoals().build();
    }

    // ------------------------- Реагируем на действия Шариков ------------------
    private class BallObserver implements BallActionListener {

        @Override
        public void ballHasMoved(BallActionEvent e) {
            if(e.ball().getOwner() == null) {
                _field.deleteBall(e.ball());
            }
        }
    }


}
