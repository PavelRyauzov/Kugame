package Model.gamefield;

import Model.gamefield.Cell;

import java.util.ArrayList;
import java.util.HashMap;

public class CellRow {

    // ----------------------- Свойства --------------------------
    private int _startOfLine;
    private ArrayList<Cell> cells = new ArrayList<>();

    public ArrayList<Cell> cells() { return cells; }

    public Cell getCell(int cellIndex) { return cells.get(cellIndex); }

    public int startOfLine() { return _startOfLine; }

    public int length() { return cells.size(); }

    private void validate(int startOfLine, int cellNumber) {
        if(startOfLine < 0 || cellNumber < 0) {
            throw new IllegalArgumentException();
        }
    }

    // ----------------------- Порождение --------------------------
    public CellRow(int startOfLine, int cellNumber) {

        validate(startOfLine, cellNumber);

        _startOfLine = startOfLine;

        for (int i = 0; i < cellNumber; i++) {
            cells.add(new Cell());
        }
    }
}
