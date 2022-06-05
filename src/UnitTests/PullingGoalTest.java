package UnitTests;

import Model.gamefield.Cell;
import Model.units.Ball;
import Model.units.MulticoloredGoal;
import Model.units.PullingGoal;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;

// Тесты
// 1. Несколько шариков разных цветов
// 2. Несколько шариков одного цвета
// 3. Один шарик

public class PullingGoalTest {

    @Test
    public void takeBall_ONE_BALL() {

        // Исходные данные
        Cell ownerCell = new Cell();
        Ball blueBall = new Ball(Color.blue);
        ownerCell.setUnit(blueBall);

        PullingGoal goal = new PullingGoal();

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
    public void takeBall_SEVERAL_BALLS_DIFFERENT_COLORS() {

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

        PullingGoal goal = new PullingGoal();

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
    public void takeBall_SEVERAL_BALLS_SAME_COLOR() {
        // Исходные данные
        Cell ownerCell1 = new Cell();
        Cell ownerCell2 = new Cell();
        Cell ownerCell3 = new Cell();
        Ball ball1 = new Ball(Color.blue);
        Ball ball2 = new Ball(Color.blue);
        Ball ball3 = new Ball(Color.blue);
        ownerCell1.setUnit(ball1);
        ownerCell2.setUnit(ball2);
        ownerCell3.setUnit(ball3);

        PullingGoal goal = new PullingGoal();

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
}
