package Model.units;

import java.awt.*;
import java.util.ArrayList;

public class SingleColoredGoal extends MulticoloredGoal {

    public SingleColoredGoal(Color color) {
        _colors.add(color);
    }

    public ArrayList<Color> colors() {
        throw new UnsupportedOperationException("This method unsupported in this class, try method color()");
    }

    public Color color() { return _colors.get(0); }

    @Override
    public boolean canPass(Ball ball) {
        return _colors.contains(ball.color());
    }

    @Override
    public String toString() {
        return "SG";
    }
}
