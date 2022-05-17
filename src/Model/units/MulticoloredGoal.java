package Model.units;

import Model.Game;
import Model.Unit;
import Model.events.BallActionEvent;
import Model.events.BallActionListener;

import java.awt.*;
import java.util.ArrayList;

public class MulticoloredGoal extends Unit {

    protected ArrayList<Color> _colors = new ArrayList<>();

    public ArrayList<Color> colors() { return _colors; }

    protected ArrayList<Ball> _balls = new ArrayList<>();

    public MulticoloredGoal(ArrayList<Color> colors) {
        _colors = colors;
    }

    protected MulticoloredGoal() {}

    public boolean canPass(Ball ball) {
        return _colors.contains(ball.color());
    }

    public void takeBall(Ball ball) {
        
        _balls.add((Ball) ball.getOwner().extractUnit());
    }

    @Override
    public String toString() {
        return "MG";
    }
}
