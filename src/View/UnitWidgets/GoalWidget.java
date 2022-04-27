package View.UnitWidgets;

import Model.Unit;
import Model.units.Ball;
import Model.units.Goal;
import View.UnitWidget;

import java.awt.*;

public class GoalWidget extends UnitWidget {
    public GoalWidget(Unit unit, Graphics g) {
        super(unit, g);

        setImg("src\\View\\UnitWidgets\\images\\square.png");

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(_img, 0, 0, 65, 65, ((Goal) _unit).color(), null);
    }
}
