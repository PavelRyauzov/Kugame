package View.UnitWidgets;

import Model.Unit;
import View.UnitWidget;

import java.awt.*;

public class BarrierWidget extends UnitWidget {
    public BarrierWidget(Unit unit, Graphics g) {
        super(unit, g);

        setImg("src/View/UnitWidgets/images/square.png");

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(_img, 0, 0, 65, 65, Color.gray, null);
    }
}
