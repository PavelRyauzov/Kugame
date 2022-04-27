package View.UnitWidgets;

import Model.Unit;
import Model.units.Ball;
import Model.units.Goal;
import View.UnitWidget;

import java.awt.*;

public class GoalWidget extends UnitWidget {
    public GoalWidget(Unit unit, Graphics g) {
        super(unit, g);

        setImg("src\\View\\UnitWidgets\\images\\goal1.png");

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (getImg() == null) { return; }

        g.drawImage(getImg(), 0, 0, 65, 65, ((Goal) getUnit()).color(), null);
    }
}
