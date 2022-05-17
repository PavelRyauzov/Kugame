package View;

import Model.Unit;

import javax.swing.*;
import java.awt.*;

public class UnitWidget extends JPanel {
    protected Unit _unit;
    protected Image _img;

    public UnitWidget(Unit unit, Graphics g) {
        _unit = unit;
    }

    public void setImg(String imgPath) {
        _img = new ImageIcon(imgPath).getImage();
    }

    @Override
    public void paint(Graphics g) {
        if (_img == null) { return; }
    }
}
