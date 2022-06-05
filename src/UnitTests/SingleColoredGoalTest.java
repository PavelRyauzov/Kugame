package UnitTests;

import Model.gamefield.Cell;
import Model.units.Ball;
import Model.units.MulticoloredGoal;
import Model.units.SingleColoredGoal;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;

// Тесты
// 1. Подходящие шарики - один, несколько
// 2. Неподходящие шарики разных цветов

public class SingleColoredGoalTest {

    @Test
    public void takeBall_ONE_MATCHING_BALL() {

        // Исходные данные
        Cell ownerCell = new Cell();
        Ball blueBall = new Ball(Color.blue);
        ownerCell.setUnit(blueBall);

        SingleColoredGoal goal = new SingleColoredGoal(Color.blue);

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
    public void takeBall_THREE_MATCHING_BALLS() {

        // Исходные данные
        Cell ownerCell1 = new Cell();
        Cell ownerCell2 = new Cell();
        Cell ownerCell3 = new Cell();
        Ball ball1 = new Ball(Color.cyan);
        Ball ball2 = new Ball(Color.cyan);
        Ball ball3 = new Ball(Color.cyan);
        ownerCell1.setUnit(ball1);
        ownerCell2.setUnit(ball2);
        ownerCell3.setUnit(ball3);

        SingleColoredGoal goal = new SingleColoredGoal(Color.cyan);

        // Вызов тестируемой функции
        goal.takeBall(ball1);
        goal.takeBall(ball2);
        goal.takeBall(ball3);

        // Вывод
        boolean isSuccess = false;

        if (goal.balls().size() == 3) {
            if (goal.balls().get(0) == ball1 && goal.balls().get(1) == ball2 && goal.balls().get(2) == ball3) {
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

        SingleColoredGoal goal = new SingleColoredGoal(Color.cyan);

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
}
