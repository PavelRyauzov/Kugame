package View.UnitWidgets;

import Model.Unit;
import Model.units.MulticoloredGoal;
import View.UnitWidget;

import java.awt.*;

public class PullingGoalWidget extends UnitWidget {

    public PullingGoalWidget(Unit unit, Graphics g) {
        super(unit, g);

        setImg("src/View/UnitWidgets/images/pullingGoal.png");

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(_img, 0, 0, 65, 65,null);
    }
}
