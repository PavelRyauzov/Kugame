package Model.gamefield;

import Model.gamefield.Cell;

import java.util.HashMap;

public class CellRow {

    // ----------------------- Свойства --------------------------
    private int _startOfLine;
    private int _length;
    private HashMap<Integer, Cell> cells = new HashMap<>();

    public Cell getCell(int cellIndex) { return cells.get(cellIndex); }

    public int startOfLine() { return _startOfLine; }

    public int length() { return _length; }

    private void validate(int startOfLine, int cellNumber) {
        if(startOfLine < 0 || cellNumber < 0) {
            throw new IllegalArgumentException();
        }
    }

    // ----------------------- Порождение --------------------------
    public CellRow(int startOfLine, int cellNumber) {

        validate(startOfLine, cellNumber);

        _startOfLine = startOfLine;
        _length = cellNumber;

        for (int i = 0; i < cellNumber; i++) {
            cells.put(i, new Cell());
        }
    }
}
