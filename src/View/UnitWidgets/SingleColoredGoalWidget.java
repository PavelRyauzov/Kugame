package View.UnitWidgets;

import Model.Unit;
import Model.units.MulticoloredGoal;
import Model.units.SingleColoredGoal;
import View.UnitWidget;

import java.awt.*;

public class SingleColoredGoalWidget extends UnitWidget {
    public SingleColoredGoalWidget(Unit unit, Graphics g) {
        super(unit, g);

        setImg("src/View/UnitWidgets/images/square.png");

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(_img, 0, 0, 65, 65, ((SingleColoredGoal) _unit).color(), null);
    }
}
