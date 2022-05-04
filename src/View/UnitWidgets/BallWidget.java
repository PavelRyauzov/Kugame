package View.UnitWidgets;

import Model.Unit;
import Model.units.Ball;
import View.UnitWidget;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BallWidget extends UnitWidget {


    public BallWidget(Unit unit, Graphics g) {
        super(unit, g);

        setImg("src/View/UnitWidgets/images/ball1.png");

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(_img, 0, 0, 65, 65, ((Ball) _unit).color(), null);
    }
}
