import Model.Game;
import Model.gamefield.Direction;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.maps.SimpleGameMap;
import Model.units.Ball;
import View.GameFrame;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameFrame mainW = new GameFrame();
                mainW.setVisible(true);
            }
        });

    }
}
