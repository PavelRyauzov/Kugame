package Model.units;

import java.awt.*;
import java.util.ArrayList;

public class MulticoloredGoal extends Goal{

    ArrayList<Color> _colors = new ArrayList<>();

    public ArrayList<Color> colors() {
        return _colors;
    }

    public MulticoloredGoal(Color color) {
        super();
        _colors.add(color);
    }

    public void addColor(Color color) {
        _colors.add(color);
    }

    @Override
    public boolean canPass(Ball ball) {
        return _colors.contains(ball.color());
    }
}
