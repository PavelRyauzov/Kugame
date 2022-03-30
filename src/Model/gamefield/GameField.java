package Model.gamefield;

import Model.units.Ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GameField {

    public ArrayList<Ball> balls;
    private HashMap<Integer, CellRow> cellRows;

    public GameField() {
        super();
    }

    public GameField(HashMap<Integer, CellRow> cellRows, ArrayList<Ball> balls) {

        this();
        this.cellRows = cellRows;
        this.balls = balls;
    }

    // Определить длину самой длинной строки
    public static int lengthOfMaxRow(HashMap<Integer, CellRow> cellRows) {

        ArrayList<Integer> rowsLength = new ArrayList<>();

        for (int rowIndex = 0; rowIndex < cellRows.size(); rowIndex++) {
            rowsLength.add(cellRows.get(rowIndex).length());
        }

        return Collections.max(rowsLength);
    }
}
