package Model;

import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;

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
    }

    private GameField constructLevel() {
        return _map.createField().seedBalls().seedBarriers().seedGoals().build();
    }

    // ------------------------- Реагируем на действия Шариков ------------------
    private class BallObserver implements BallActionListener {

        @Override
        public void ballHasMoved(BallActionEvent e) {
            
        }
    }
}
