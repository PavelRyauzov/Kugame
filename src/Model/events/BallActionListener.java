package Model.events;

import Model.gamefield.Direction;

import java.util.EventListener;

/*
 * Слушатель действий шарика
 */
public interface BallActionListener extends EventListener {

    void ballHasAStep(BallActionEvent e);
    void ballHasAMoved(BallActionEvent e);
}
