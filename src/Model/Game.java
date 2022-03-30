package Model;

import Model.gamefield.GameField;
import Model.gamefield.GameMap;

public class Game {

    private GameMap map;

    public Game(GameMap map) {
        super();
        this.map = map;
        if (this.map == null) {
            throw new IllegalArgumentException("Ошибка при порождении GameMap");
        }
    }

    public GameField constructLevel() {
        return map.createField().seedBalls().seedBarriers().seedGoals().build();
    }
}
