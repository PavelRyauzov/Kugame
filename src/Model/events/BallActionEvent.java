package Model.events;

import Model.units.Ball;

import java.util.EventObject;

/*
 * Событие, связанное с деятельностью Шарика
 */
public class BallActionEvent extends EventObject {

    // -------------------------------- Шарик --------------------------------------
    Ball _ball;

    // Событие связанное с деятельностью Шарика
    public BallActionEvent(Object source) {
        super(source);
    }
}
