package Model.events;

import Model.gamefield.Direction;
import Model.units.Ball;

import java.util.ArrayList;
import java.util.List;

public class BallActionCreator {

    private List<BallActionListener> _ballListeners = new ArrayList<>();

    public void addBallActionListener(BallActionListener listener) {
        _ballListeners.add(listener);
    }

    public void removeBallActionListener(BallActionListener listener) {
        _ballListeners.remove(listener);
    }

    public void fireBallHasAStep(Ball ball, Direction direction) {
        BallActionEvent event = new BallActionEvent(ball);
        event.setBall(ball);
        event.setDirection(direction);
        for (Object listener: _ballListeners) {
            ((BallActionListener)listener).ballHasAStep(event);
        }
    }

    public void fireBallHasAMoved(Ball ball, Direction direction) {
        BallActionEvent event = new BallActionEvent(ball);
        event.setBall(ball);
        event.setDirection(direction);
        for (Object listener: _ballListeners) {
            ((BallActionListener)listener).ballHasAMoved(event);
        }
    }
}
