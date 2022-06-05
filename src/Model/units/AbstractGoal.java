package Model.units;

import Model.Unit;

import java.util.ArrayList;

public abstract class AbstractGoal extends Unit {
    protected ArrayList<Ball> _balls = new ArrayList<>();
    public ArrayList<Ball> balls() { return _balls; }
    public void takeBall(Ball ball) {
        _balls.add((Ball) ball.getOwner().extractUnit());
    }
}
