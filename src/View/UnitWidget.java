package View;

import Model.Unit;
import Model.units.Ball;
import Model.units.Barrier;
import Model.units.Goal;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class UnitWidget extends JPanel {
    private Unit _unit;
    private Image _img;

    public UnitWidget(Unit unit, Graphics g) {
        _unit = unit;
    }

    public Unit getUnit() {
        return _unit;
    }

    public void setImg(String imgPath) {
        _img = new ImageIcon(imgPath).getImage();
    }

    public Image getImg() {
        return _img;
    }
}
