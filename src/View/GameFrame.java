package View;

import Model.Game;
import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.events.GameEvent;
import Model.events.GameListener;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.maps.SimpleGameMap;

import javax.swing.*;

public class GameFrame extends JFrame {

    Game _game;

    public GameFrame() {

        GameMap map = new SimpleGameMap();
        _game = new Game(map);
        _game.start();

        _game.addGameListener(new GameObserver());

        GameFieldView mainBox = new GameFieldView(_game.field());

        setContentPane(mainBox);
        pack();
        setResizable(false);
        setFocusable(true);
        setTitle("Kugame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ------------------------- Реагируем на изменение состояния Игры ------------------
    private class GameObserver implements GameListener {

        @Override
        public void gameFinished(GameEvent e) {

            if (_game.field().balls().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ура! Все шарики загнаны в ворота!", "Победа!", JOptionPane.INFORMATION_MESSAGE);

                System.exit(0);
            }
        }
    }
}
