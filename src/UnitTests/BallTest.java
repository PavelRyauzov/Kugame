package UnitTests;

import Model.Game;
import Model.gamefield.Cell;
import Model.gamefield.Direction;
import Model.gamefield.GameMap;
import Model.maps.SimpleGameMap;
import Model.maps.TestSimpleGameMap;
import Model.units.AbstractGoal;
import Model.units.Ball;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BallTest {

    // Тесты
    // 1. Шарик движется и врезается в препятствие
    // 2. Шарик движется и врезается в другой шарик
    // 3. Шарик движется и врезается в ворота неподходящего цвета
    // 4. Шарик движется и попадает в ворота подходящего цвета

    @Test
    public void move_IN_BARRIER() throws InterruptedException {

        // Исходные данные
        GameMap map = new TestSimpleGameMap();
        Game game = new Game(map);
        game.start();

        Ball ball = game.field().balls().get(0);

        // Эталонные данные
        Cell expBallOwner = game.field().cellRows().get(1).getCell(3);

        // Вызов тестируемой функции
       ball.move(Direction.north());
       Thread.sleep(500);

        // Вывод
        boolean isSuccess = false;

        if (game.field().balls().size() == 2) {
            if (ball.getOwner() == expBallOwner) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void move_IN_MATCHING_GOAL() throws InterruptedException {

        // Исходные данные
        GameMap map = new TestSimpleGameMap();
        Game game = new Game(map);
        game.start();

        Ball ball = game.field().balls().get(0);
        AbstractGoal goal = game.field().goals().get(0);

        // Эталонные данные
        Cell expBallOwner = null;

        // Вызов тестируемой функции
        ball.move(Direction.south());
        Thread.sleep(500);

        // Вывод
        boolean isSuccess = false;

        if (game.field().balls().size() == 1) {
            if (ball.getOwner() == expBallOwner) {
                if (goal.balls().get(0) == ball) {
                    isSuccess = true;
                }
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void move_IN_NOT_MATCHING_GOAL() throws InterruptedException {

        // Исходные данные
        GameMap map = new TestSimpleGameMap();
        Game game = new Game(map);
        game.start();

        Ball ball = game.field().balls().get(0);

        // Эталонные данные
        Cell expBallOwner = game.field().cellRows().get(3).getCell(4);

        // Вызов тестируемой функции
        ball.move(Direction.east());
        Thread.sleep(500);

        // Вывод
        boolean isSuccess = false;

        if (game.field().balls().size() == 2) {
            if (ball.getOwner() == expBallOwner) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }

    @Test
    public void move_IN_OTHER_BALL() throws InterruptedException {

        // Исходные данные
        GameMap map = new TestSimpleGameMap();
        Game game = new Game(map);
        game.start();

        Ball ball = game.field().balls().get(0);

        // Эталонные данные
        Cell expBallOwner = game.field().cellRows().get(3).getCell(2);

        // Вызов тестируемой функции
        ball.move(Direction.west());
        Thread.sleep(500);

        // Вывод
        boolean isSuccess = false;

        if (game.field().balls().size() == 2) {
            if (ball.getOwner() == expBallOwner) {
                isSuccess = true;
            }
        }

        if (!isSuccess) {
            Assert.fail();
        }
    }
}
