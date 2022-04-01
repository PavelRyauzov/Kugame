import Model.Game;
import Model.gamefield.Direction;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.maps.SimpleGameMap;
import Model.units.Ball;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        GameMap map = new SimpleGameMap();
        Game game = new Game(map);
        GameField field = game.constructLevel();

        ArrayList<Ball> balls = field.balls();

        balls.get(0).move(Direction.east());

        System.out.println("Все ок!");

    }
}
