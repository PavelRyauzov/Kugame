package Model.maps;

import Model.gamefield.CellRow;
import Model.gamefield.Direction;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.units.*;

import java.awt.*;
import java.util.ArrayList;

public class TestSimpleGameMap implements GameMap {

    private ArrayList<CellRow> cellRows = new ArrayList<>();
    private ArrayList<Ball> balls = new ArrayList<>();

    private ArrayList<AbstractGoal> goals = new ArrayList<>();

    public TestSimpleGameMap() {
        super();
    }

    @Override
    public GameMap createField() {

        // Создаем строки с ячейками
        for (int i = 0; i < 6; i++) {
            cellRows.add(new CellRow(0, 6));
        }

        // Связываем ячейки
        // По горизонтали
        for (int rowIndex = 0; rowIndex < cellRows.size(); rowIndex++) {
            for (int cellIndex = 0; cellIndex < cellRows.get(rowIndex).length() - 1; cellIndex++) {
                cellRows.get(rowIndex).getCell(cellIndex).setNeighbor(Direction.east(),
                        cellRows.get(rowIndex).getCell(cellIndex + 1));
            }
        }

        // Определяем длину самой длинной строки
        int maxRowLength = GameField.lengthOfMaxRow(cellRows);

        // По вертикали
        for (int rowIndex = 0; rowIndex < cellRows.size() - 1; rowIndex++) {
            for (int cellIndex = 0; cellIndex < maxRowLength; cellIndex++) {
                if (cellIndex >= cellRows.get(rowIndex).startOfLine()) {
                    cellRows.get(rowIndex).getCell(cellIndex - cellRows.get(rowIndex).startOfLine()).setNeighbor(Direction.south(),
                            cellRows.get(rowIndex + 1).getCell(cellIndex - cellRows.get(rowIndex + 1).startOfLine()));
                }
            }
        }

        return this;
    }

    @Override
    public GameMap seedBarriers() {

        // Расставляем препятствия по периметру поля
        // Сверху
        for (int cellIndex = 0; cellIndex < cellRows.get(0).length(); cellIndex++) {
            cellRows.get(0).getCell(cellIndex).setUnit(new Barrier());
        }

        // Справа
        for (int rowIndex = 0; rowIndex < cellRows.size(); rowIndex++) {
            cellRows.get(rowIndex).getCell(cellRows.get(rowIndex).length() - 1).setUnit(new Barrier());
        }

        // Слева
        for (int rowIndex = 0; rowIndex < cellRows.size(); rowIndex++) {
            cellRows.get(rowIndex).getCell(0).setUnit(new Barrier());
        }

        // Снизу
        for (int cellIndex = 0; cellIndex < cellRows.get(4).length(); cellIndex++) {
            cellRows.get(cellRows.size() - 1).getCell(cellIndex).setUnit(new Barrier());
        }

        return this;
    }

    @Override
    public GameMap seedBalls() {

        Ball redBall = new Ball(Color.red);
        cellRows.get(3).getCell(3).setUnit(redBall);
        balls.add(redBall);

        Ball blueBall = new Ball(Color.blue);
        cellRows.get(3).getCell(1).setUnit(blueBall);
        balls.add(blueBall);

        return this;
    }

    @Override
    public GameMap seedGoals() {

        SingleColoredGoal redGoal = new SingleColoredGoal(Color.red);
        cellRows.get(5).getCell(3).setUnit(redGoal);
        goals.add(redGoal);

        SingleColoredGoal blueGoal = new SingleColoredGoal(Color.blue);
        cellRows.get(3).getCell(5).setUnit(blueGoal);
        goals.add(blueGoal);

        return this;
    }

    @Override
    public GameField build() { return new GameField(cellRows, balls, goals); }
}
