package Model.events;

import java.util.EventListener;

/*
 * Слушатель действий шарика
 */
public interface BallActionListener extends EventListener {
    void ballHasDisappeared(BallActionEvent e);
    void ballHasAStep(BallActionEvent e);
    void ballHasAMoved(BallActionEvent e);
}
