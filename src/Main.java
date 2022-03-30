import Model.Game;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.maps.SimpleGameMap;

public class Main {

    public static void main(String[] args) {
        GameMap map = new SimpleGameMap();
        Game game = new Game(map);
        GameField field = game.constructLevel();

        if (field != null) {
            System.out.println("Все ок!!!");
        }

    }
}
