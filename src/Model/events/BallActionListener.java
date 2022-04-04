package Model.events;

import java.util.EventListener;

/*
 * Слушатель действий шарика
 */
public interface BallActionListener extends EventListener {
    void ballHasMoved(BallActionEvent e);
}
