package Model.maps;

import Model.gamefield.CellRow;
import Model.gamefield.Direction;
import Model.gamefield.GameField;
import Model.gamefield.GameMap;
import Model.units.*;

import java.awt.*;
import java.util.ArrayList;

public class SimpleGameMap implements GameMap {

    private ArrayList<CellRow> cellRows = new ArrayList<>();
    private ArrayList<Ball> balls = new ArrayList<>();

    private ArrayList<AbstractGoal> goals = new ArrayList<>();

    public SimpleGameMap() {
        super();
    }

    @Override
    public GameMap createField() {

        // Создаем строки с ячейками
        cellRows.add(new CellRow(2, 8));
        cellRows.add(new CellRow(1, 9));
        for (int i = 2; i < 10; i++) {
            cellRows.add(new CellRow(0, 10));
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
        for (int cellIndex = 0; cellIndex < cellRows.get(9).length(); cellIndex++) {
            cellRows.get(cellRows.size() - 1).getCell(cellIndex).setUnit(new Barrier());
        }

        // Расставляем препятствия внутри поля
        cellRows.get(3).getCell(2).setUnit(new Barrier());

        cellRows.get(4).getCell(8).setUnit(new Barrier());

        return this;
    }

    @Override
    public GameMap seedBalls() {

        Ball redBall = new Ball(Color.red);
        cellRows.get(3).getCell(4).setUnit(redBall);
        balls.add(redBall);

        Ball greenBall = new Ball(Color.green);
        cellRows.get(7).getCell(3).setUnit(greenBall);
        balls.add(greenBall);

        Ball blueBall = new Ball(Color.blue);
        cellRows.get(2).getCell(8).setUnit(blueBall);
        balls.add(blueBall);

//        Ball blueBall = new Ball(Color.blue);
//        cellRows.get(3).getCell(3).setUnit(blueBall);
//        balls.add(blueBall);

        return this;
    }

    @Override
    public GameMap seedGoals() {

        SingleColoredGoal redGoal = new SingleColoredGoal(Color.red);
        cellRows.get(9).getCell(3).setUnit(redGoal);
        goals.add(redGoal);

        SingleColoredGoal greenGoal = new SingleColoredGoal(Color.green);
        cellRows.get(9).getCell(8).setUnit(greenGoal);
        goals.add(greenGoal);

        SingleColoredGoal blueGoal = new SingleColoredGoal(Color.blue);
        cellRows.get(3).getCell(9).setUnit(blueGoal);
        goals.add(blueGoal);

//        ArrayList<Color> colors = new ArrayList<>();
//        colors.add(Color.blue);
//        colors.add(Color.green);
//        MulticoloredGoal mcGoal = new MulticoloredGoal(colors);
//        cellRows.get(3).getCell(9).setUnit(mcGoal);
//        goals.add(mcGoal);

//        PullingGoal pullingGoal = new PullingGoal();
//        cellRows.get(3).getCell(9).setUnit(pullingGoal);
//        goals.add(pullingGoal);

        return this;
    }

    @Override
    public GameField build() { return new GameField(cellRows, balls, goals); }
}
