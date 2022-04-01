package Model.gamefield;

import Model.Unit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cell {

    // ----------------------- Порождение --------------------------
    public Cell() {
        super();
    }

    // ---------------------- Соседи -----------------------
    private final Map<Direction, Cell> _neighbors = new HashMap<>();

    public Cell neighbor(Direction direct) {

        if(_neighbors.containsKey(direct)) {
            return _neighbors.get(direct);
        }

        return null;
    }

    public Map<Direction, Cell> neighbors() {
        return Collections.unmodifiableMap(_neighbors);
    }

    public void setNeighbor(Direction direct, Cell neighbor) {
        if(neighbor != this && !isNeighbor(neighbor)) {
            _neighbors.put(direct, neighbor);
            neighbor.setNeighbor(direct.opposite(), this);
        }
    }

    public boolean isNeighbor(Cell other) {
        return _neighbors.containsValue(other);
    }


    // ------------------------------- Владение юнитом ---------------------------------
    Unit _ownedUnit;

    public Unit getUnit() {
        return _ownedUnit;
    }

    public void setUnit(Unit unit) {
        _ownedUnit = unit;
        _ownedUnit.setOwner(this);
    }

    public Unit extractUnit() {

        if (isEmpty()) {
            return null;
        }

        Unit removedUnit =_ownedUnit;

        _ownedUnit.removeOwner();

        _ownedUnit = null;

        return removedUnit;
    }

    public boolean isEmpty() { return _ownedUnit == null; }
}
