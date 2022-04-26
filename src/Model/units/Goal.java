package Model.units;

import Model.Unit;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Goal extends Unit {

    private Color _color;

    private ArrayList<Ball> _balls = new ArrayList<>();

    public Goal(Color color) {
        _color = color;
    }

    public boolean canPass(Ball ball) {
        return ball.color() == _color;
    }

    public void takeBall(Ball ball) {
        _balls.add((Ball) ball.getOwner().extractUnit());
    }

    @Override
    public String toString() {
        return "G";
    }
}
