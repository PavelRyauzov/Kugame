package View;

import Model.Unit;
import Model.gamefield.Cell;
import Model.units.*;
import View.UnitWidgets.*;

import javax.swing.*;
import java.awt.*;

public class CellWidget extends JPanel  {

    public static final int CELL_SIZE = 65;
    private static final Color BACKGROUND_COLOR = new Color(180, 180, 180);
    private static final Color RECT_COLOR = new Color(180, 180, 180);

    private final Cell _cell;

    public CellWidget(Cell cell) {

        setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));

        setBackground(BACKGROUND_COLOR);

        _cell = cell;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        super.paintComponent(g);

        Graphics2D gr2d = (Graphics2D) g;
        gr2d.setStroke( new BasicStroke(2) );
        gr2d.setPaint( RECT_COLOR );

        gr2d.drawRect(0, 0, CELL_SIZE, CELL_SIZE);

        Unit u = _cell.getUnit();

        if(u != null) {
            UnitWidget uw = new UnitWidget(u, g);

            if (u instanceof Ball) {
                 uw = new BallWidget(u, g);
            } else if (u instanceof PullingGoal) {
                uw = new PullingGoalWidget(u, g);
            } else if (u instanceof SingleColoredGoal) {
                uw = new SingleColoredGoalWidget(u, g);
            } else if (u instanceof MulticoloredGoal) {
                uw = new MulticoloredGoalWidget(u, g);
            } else if (u instanceof Barrier) {
                uw = new BarrierWidget(u, g);
            }

            this.add(uw);
        }
    }
}
