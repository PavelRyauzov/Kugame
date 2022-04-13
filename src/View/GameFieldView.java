package View;

import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.gamefield.Cell;
import Model.gamefield.CellRow;
import Model.gamefield.Direction;
import Model.gamefield.GameField;
import Model.units.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFieldView extends JPanel {

    private GameField _field;

    public GameFieldView(GameField field) {

        _field = field;

        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

//        constraints.gridy = 0;
//        for (CellRow cellRow: _field.cellRows()) {
//            constraints.gridx = 0;
//            for(Cell cell: cellRow.cells()) {
//                add(new CellWidget(new Cell()), constraints);
//                constraints.gridx++;
//            }
//            constraints.gridy++;
//        }

        constraints.gridy = 0;
        for (CellRow cellRow : _field.cellRows()) {
            constraints.gridx = cellRow.startOfLine();
            for (Cell cell : cellRow.cells()) {
                add(new CellWidget(cell), constraints);
                constraints.gridx++;
            }
            constraints.gridy++;
        }

        //addMouseMotionListener(new MouseController());
        addMouseListener(new MouseController());
        setFocusable(true);
    }

    private class MouseController implements MouseListener {

        int x = 0;
        int y = 0;

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

            if (x != 0 && y != 0) {
                int originalCellIndex = x / CellWidget.CELL_SIZE;
                int originalRowIndex = y / CellWidget.CELL_SIZE;

                int receivedCellIndex = e.getX() / CellWidget.CELL_SIZE;
                int receivedRowIndex = e.getY() / CellWidget.CELL_SIZE;

                Direction direct = null;
                if (originalCellIndex == receivedCellIndex && originalRowIndex > receivedRowIndex) {
                    direct = Direction.north();
                } else if (originalCellIndex == receivedCellIndex && originalRowIndex < receivedRowIndex) {
                    direct = Direction.south();
                } else if (originalRowIndex == receivedRowIndex && originalCellIndex > receivedCellIndex) {
                    direct = Direction.west();
                } else if (originalRowIndex == receivedRowIndex && originalCellIndex < receivedCellIndex) {
                    direct = Direction.east();
                }

                if (direct != null) {
                    if (_field.cellRows().get(originalRowIndex).getCell(originalCellIndex - _field.cellRows().get(originalRowIndex).startOfLine()).getUnit() instanceof Ball) {

                        Ball ball = (Ball) _field.cellRows().get(originalRowIndex).getCell(originalCellIndex - _field.cellRows().get(originalRowIndex).startOfLine()).getUnit();
                        ball.move(direct);

                        repaint();
                    }
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}



