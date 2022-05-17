package Model.events;

import Model.gamefield.Direction;
import Model.units.Ball;

import java.util.EventObject;

/*
 * Событие, связанное с деятельностью Шарика
 */
public class BallActionEvent extends EventObject {

    // ------------------------------ Шарик ------------------------------------
    private Ball _ball;
    public void setBall(Ball ball){
        _ball = ball;
    }
    public Ball ball(){
        return _ball;
    }

    private Direction _ballMovingDirection;
    public void setDirection(Direction direction) {
        _ballMovingDirection = direction;
    }
    public Direction ballMovingDirection(){
        return _ballMovingDirection;
    }

    // Событие связанное с деятельностью Шарика
    public BallActionEvent(Object source) {
        super(source);
    }
}
