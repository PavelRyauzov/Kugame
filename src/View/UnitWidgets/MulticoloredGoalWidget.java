package View.UnitWidgets;

import Model.Unit;
import Model.units.Goal;
import Model.units.MulticoloredGoal;
import View.UnitWidget;

import java.awt.*;

public class MulticoloredGoalWidget extends UnitWidget {

    public MulticoloredGoalWidget(Unit unit, Graphics g) {
        super(unit, g);

        setImg("src\\View\\UnitWidgets\\images\\mc.png");

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(_img, 0, 0, 65, 65,null);
    }
}
