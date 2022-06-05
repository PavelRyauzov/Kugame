package Model.units;

import Model.Game;
import Model.Unit;
import Model.events.BallActionEvent;
import Model.events.BallActionListener;

import java.awt.*;
import java.util.ArrayList;

public class MulticoloredGoal extends AbstractGoal {
    protected ArrayList<Color> _colors = new ArrayList<>();
    public MulticoloredGoal(ArrayList<Color> colors) {
        _colors = colors;
    }
    protected MulticoloredGoal() {}
    protected boolean canPass(Ball ball) {
        return _colors.contains(ball.color());
    }
    @Override
    public void takeBall(Ball ball) {

        if (canPass(ball)) { super.takeBall(ball); }
    }
    @Override
    public String toString() {
        return "MG";
    }
}
