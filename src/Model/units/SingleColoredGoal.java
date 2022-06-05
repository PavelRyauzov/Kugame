package Model.units;

import java.awt.*;
import java.util.ArrayList;

public class SingleColoredGoal extends MulticoloredGoal {

    public SingleColoredGoal(Color color) {

        super();
        _colors.add(color);
    }

    public Color color() { return _colors.get(0); }
    @Override
    public String toString() {
        return "SG";
    }
}
