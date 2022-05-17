package View;

import Model.Game;
import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.events.GameEvent;
import Model.events.GameListener;
import Model.gamefield.Direction;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.maps.SimpleGameMap;
import Model.units.Ball;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    Game _game;
    GameFieldView _mainBox;

    public GameFrame() {

        GameMap map = new SimpleGameMap();
        _game = new Game(map);
        _game.start();

        _game.addGameListener(new GameObserver());

        for (Ball ball: _game.field().balls()) {
            _game.ballActionCreator().addBallActionListener(new BallObserver());
        }

        _mainBox = new GameFieldView(_game.field());

        setContentPane(_mainBox);
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

            _mainBox.repaint();

            if (_game.field().balls().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ура! Все шарики загнаны в ворота!", "Победа!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }

    // ------------------------- Реагируем на действия Шарика ------------------

    private class BallObserver implements BallActionListener {

        @Override
        public void ballHasAStep(BallActionEvent e) {
            setEnabled(false);
            _mainBox.repaint();
        }

        @Override
        public void ballHasAMoved(BallActionEvent e, Direction direction) {
            _mainBox.repaint();
            setEnabled(true);
        }
    }
}
