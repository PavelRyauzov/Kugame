package Model;

import Model.gamefield.Cell;

public class Unit {
    // ---------------------- Владелец ---------------------
    private Cell _owner;

    public void setOwner(Cell cell) {
        _owner = cell;
    }

    public Cell getOwner() { return _owner; }

    public void removeOwner() { _owner = null; }
}
