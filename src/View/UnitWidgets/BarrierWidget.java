package View.UnitWidgets;

import Model.Unit;
import Model.units.Goal;
import View.UnitWidget;

import java.awt.*;
import java.io.File;

public class BarrierWidget extends UnitWidget {
    public BarrierWidget(Unit unit, Graphics g) {
        super(unit, g);

        setImg("src\\View\\UnitWidgets\\images\\goal1.png");

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (getImg() == null) { return; }

        g.drawImage(getImg(), 0, 0, 65, 65, Color.gray, null);
    }
}
