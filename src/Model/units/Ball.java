package Model.units;

import Model.Unit;
import Model.gamefield.Cell;
import Model.gamefield.Direction;

import java.awt.*;

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
    }
}
