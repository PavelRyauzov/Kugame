package Model.gamefield;

import Model.units.Ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GameField {

    private ArrayList<CellRow> _cellRows;
    private ArrayList<Ball> _balls;

    public ArrayList<Ball> balls() { return _balls; }

    public GameField() {
        super();
    }

    public GameField(ArrayList<CellRow> cellRows, ArrayList<Ball> balls) {

        this();
        _cellRows = cellRows;
        _balls = balls;
    }

    // Определить длину самой длинной строки
    public static int lengthOfMaxRow(ArrayList<CellRow> cellRows) {

        ArrayList<Integer> rowsLength = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < cellRows.size(); rowIndex++) {
            rowsLength.add(cellRows.get(rowIndex).length());
        }

        return Collections.max(rowsLength);
    }
}
