package Model.gamefield;

import Model.Unit;
import Model.units.Ball;
import Model.units.MulticoloredGoal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GameField {

    // --------------------- Строки из ячеек -------------------
    private ArrayList<CellRow> _cellRows;

    public ArrayList<CellRow> cellRows() { return _cellRows; }

    // ------------------------- Шарики -----------------------
    private ArrayList<Ball> _balls;

    public ArrayList<Ball> balls() { return _balls; }

    // ------------------------- Ворота -----------------------
    private ArrayList<MulticoloredGoal> _goals;

    public ArrayList<MulticoloredGoal> goals() { return _goals; }

    public void deleteBall(Ball ball) { _balls.remove(ball); }

    // ------------------------ Порождение ----------------------
    public GameField() {
        super();
    }

    public GameField(ArrayList<CellRow> cellRows, ArrayList<Ball> balls, ArrayList<MulticoloredGoal> goals) {
        this();
        _cellRows = cellRows;
        _balls = balls;
        _goals = goals;
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
