package UnitTests;

import Model.gamefield.Cell;
import Model.units.Ball;
import Model.units.MulticoloredGoal;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;

// Тесты
// 1. Один цвет у ворот и один подходящий шарик
// 2. Один цвет у ворот и один неподходящий шарик
// 3. Несколько цветов - несколько шариков, все подходят
// 4. Несколько цветов - несколько шариков, один подходит, другие нет
// 5. Несколько цветов - несколько шариков, один не подходит, другие да
// 6. Несколько цветов - несколько шариков, ни один не подходит
// 7. Несколько цветов - несколько шариков одного подходящего цвета

public class MulticoloredGoalTest {

    @Test
    public void takeBall_ONE_MATCHING_BALL() {

        // Исходные данные
        Cell ownerCell = new Cell();
        Ball blueBall = new Ball(Color.blue);
        ownerCell.setUnit(blueBall);

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.blue);
        MulticoloredGoal goal = new MulticoloredGoal(colors);

        // Вызов тестируемой функции
        goal.takeBall(blueBall);

        // Вывод
        boolean isSuccess = false;

        if (goal.balls().size() == 1) {
            if (goal.balls().get(0) == blueBall) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void takeBall_ONE_NOT_MATCHING_BALL() {

        // Исходные данные
        Cell ownerCell = new Cell();
        Ball redBall = new Ball(Color.red);
        ownerCell.setUnit(redBall);

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.blue);
        MulticoloredGoal goal = new MulticoloredGoal(colors);

        // Вызов тестируемой функции
        goal.takeBall(redBall);

        // Вывод
        boolean isSuccess = false;

        if (goal.balls().size() == 0) {
            isSuccess = true;
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void takeBall_THREE_MATCHING_BALLS() {

        // Исходные данные
        Cell ownerCell1 = new Cell();
        Cell ownerCell2 = new Cell();
        Cell ownerCell3 = new Cell();
        Ball blueBall = new Ball(Color.blue);
        Ball redBall = new Ball(Color.red);
        Ball greenBall = new Ball(Color.green);
        ownerCell1.setUnit(blueBall);
        ownerCell2.setUnit(redBall);
        ownerCell3.setUnit(greenBall);

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.green);
        MulticoloredGoal goal = new MulticoloredGoal(colors);

        // Вызов тестируемой функции
        goal.takeBall(blueBall);
        goal.takeBall(redBall);
        goal.takeBall(greenBall);

        // Вывод
        boolean isSuccess = false;

        if (goal.balls().size() == 3) {
            if (goal.balls().get(0) == blueBall && goal.balls().get(1) == redBall && goal.balls().get(2) == greenBall) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void takeBall_ONLY_ONE_MATCHING_BALL_OF_A_SEVERAL() {

        // Исходные данные
        Cell ownerCell1 = new Cell();
        Cell ownerCell2 = new Cell();
        Cell ownerCell3 = new Cell();
        Ball blueBall = new Ball(Color.blue);
        Ball grayBall = new Ball(Color.gray);
        Ball blackBall = new Ball(Color.black);
        ownerCell1.setUnit(blueBall);
        ownerCell2.setUnit(grayBall);
        ownerCell3.setUnit(blackBall);

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.green);
        MulticoloredGoal goal = new MulticoloredGoal(colors);

        // Вызов тестируемой функции
        goal.takeBall(blueBall);
        goal.takeBall(grayBall);
        goal.takeBall(blackBall);

        // Вывод
        boolean isSuccess = false;

        if (goal.balls().size() == 1) {
            if (goal.balls().get(0) == blueBall) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void takeBall_ONLY_ONE_NOT_MATCHING_BALL_OF_A_SEVERAL() {

        // Исходные данные
        Cell ownerCell1 = new Cell();
        Cell ownerCell2 = new Cell();
        Cell ownerCell3 = new Cell();
        Ball blackBall = new Ball(Color.black);
        Ball redBall = new Ball(Color.red);
        Ball greenBall = new Ball(Color.green);
        ownerCell1.setUnit(blackBall);
        ownerCell2.setUnit(redBall);
        ownerCell3.setUnit(greenBall);

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.green);
        MulticoloredGoal goal = new MulticoloredGoal(colors);

        // Вызов тестируемой функции
        goal.takeBall(blackBall);
        goal.takeBall(redBall);
        goal.takeBall(greenBall);

        // Вывод
        boolean isSuccess = false;

        if (goal.balls().size() == 2) {
            if (goal.balls().get(0) == redBall && goal.balls().get(1) == greenBall) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void takeBall_NOT_MATCHING_BALLS() {

        // Исходные данные
        Cell ownerCell1 = new Cell();
        Cell ownerCell2 = new Cell();
        Cell ownerCell3 = new Cell();
        Ball blackBall = new Ball(Color.black);
        Ball grayBall = new Ball(Color.gray);
        Ball whiteBall = new Ball(Color.white);
        ownerCell1.setUnit(blackBall);
        ownerCell2.setUnit(grayBall);
        ownerCell3.setUnit(whiteBall);

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.green);
        MulticoloredGoal goal = new MulticoloredGoal(colors);

        // Вызов тестируемой функции
        goal.takeBall(blackBall);
        goal.takeBall(grayBall);
        goal.takeBall(whiteBall);

        // Вывод
        boolean isSuccess = false;

        if (goal.balls().size() == 0) {
            isSuccess = true;
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void takeBall_THREE_MATCHING_BALLS_EQUALS_COLOR() {

        // Исходные данные
        Cell ownerCell1 = new Cell();
        Cell ownerCell2 = new Cell();
        Cell ownerCell3 = new Cell();
        Ball blueBall = new Ball(Color.blue);
        Ball redBall = new Ball(Color.red);
        Ball greenBall = new Ball(Color.green);
        ownerCell1.setUnit(blueBall);
        ownerCell2.setUnit(redBall);
        ownerCell3.setUnit(greenBall);

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.blue);
        colors.add(Color.red);
        colors.add(Color.green);
        MulticoloredGoal goal = new MulticoloredGoal(colors);

        // Вызов тестируемой функции
        goal.takeBall(blueBall);
        goal.takeBall(redBall);
        goal.takeBall(greenBall);

        // Вывод
        boolean isSuccess = false;

        if (goal.balls().size() == 3) {
            if (goal.balls().get(0) == blueBall && goal.balls().get(1) == redBall && goal.balls().get(2) == greenBall) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }
}
