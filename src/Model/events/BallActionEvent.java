package Model.events;

import Model.units.Ball;

import java.util.EventObject;

/*
 * Событие, связанное с деятельностью Шарика
 */
public class BallActionEvent extends EventObject {

    // ------------------------------ Шарик ------------------------------------
    Ball _ball;

    public void setBall(Ball ball){
        _ball = ball;
    }

    public Ball ball(){
        return _ball;
    }

    // Событие связанное с деятельностью Шарика
    public BallActionEvent(Object source) {
        super(source);
    }
}
