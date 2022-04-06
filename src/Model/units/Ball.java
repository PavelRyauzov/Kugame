package Model.units;

import Model.Unit;
import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.events.GameListener;
import Model.gamefield.Cell;
import Model.gamefield.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ball extends Unit {

    // ---------------------- Свойства ---------------------

    private Color _color;

    public Color color() { return _color; }


    // --------------------- Порождение --------------------

    public Ball(Color color) { _color = color; }


    // -------------------- Перемещение --------------------

    public boolean canMoveTo(Cell cell) { return cell.isEmpty(); }

    public void move(Direction direct) {

        do {
            Cell neighborCell = getOwner().neighbor(direct);

            if (neighborCell == null) {
                return;
            }

            if (!neighborCell.isEmpty()) {
                return;
            }

            neighborCell.setUnit(getOwner().extractUnit());

        } while (canMoveTo(getOwner().neighbor(direct)));

        if (getOwner().neighbor(direct).getUnit() instanceof Goal) {
            Goal goal = (Goal) getOwner().neighbor(direct).getUnit();

            if(goal.canPass(this)) {
                goal.takeBall(this);
            }
        }

        fireBallHasMoved();
    }


    // ------------------ Порождает события, связанные с движением Шарика ---------------------

    private List<BallActionListener> _listeners = new ArrayList<>();

    public void addBallActionListener(BallActionListener listener) {
        _listeners.add(listener);
    }

    public void removeBallActionListener(BallActionListener listener) {
        _listeners.remove(listener);
    }

    protected void fireBallHasMoved() {

        BallActionEvent event = new BallActionEvent(this);
        event.setBall(this);
        for (Object listener: _listeners) {
            ((BallActionListener)listener).ballHasMoved(event);
        }
    }
}
