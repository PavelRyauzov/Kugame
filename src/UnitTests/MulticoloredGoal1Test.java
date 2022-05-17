//package UnitTests;
//
//import Model.units.Ball;
//import Model.units.Goal;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.awt.*;
//import java.util.ArrayList;
//
//// Тесты
//// 1. Один шарик подходит / не подходит
//// 2. Несколько шариков - все подходят
//// 3. Несколько шариков - один подходит, другие нет
//// 4. Несколько шариков - один не подходит, другие да
//// 5. Несколько шариков - ни один не подходит
//
//public class MulticoloredGoal1Test {
//
//    @Test
//    public void canPass_ONE_MATCHING_BALL() {
//
//        // Исходные данные
//        Ball blueBall = new Ball(Color.blue);
//
//        ArrayList<Color> colors = new ArrayList<>();
//        colors.add(Color.blue);
//        Goal goal = new Goal(colors);
//
//        // Эталонные данные
//        boolean expResult = true;
//
//        // Вызов тестируемой функции
//        boolean result = goal.canPass(blueBall);
//
//        // Сравнение
//        Assert.assertEquals(expResult, result);
//    }
//
//    @Test
//    public void canPass_THREE_MATCHING_BALLS() {
//
//        // Исходные данные
//        Ball blueBall = new Ball(Color.blue);
//        Ball redBall = new Ball(Color.red);
//        Ball greenBall = new Ball(Color.green);
//
//        ArrayList<Color> colors = new ArrayList<>();
//        colors.add(Color.blue);
//        colors.add(Color.red);
//        colors.add(Color.green);
//        Goal goal = new Goal(colors);
//
//        // Эталонные данные
//        boolean expResultBlueBall = true;
//        boolean expResultRedBall = true;
//        boolean expResultGreenBall = true;
//
//        // Вызов тестируемой функции
//        boolean resultBlueBall = goal.canPass(blueBall);
//        boolean resultRedBall = goal.canPass(redBall);
//        boolean resultGreenBall = goal.canPass(greenBall);
//
//        // Сравнение
//        Assert.assertEquals(expResultBlueBall, resultBlueBall);
//        Assert.assertEquals(expResultRedBall, resultRedBall);
//        Assert.assertEquals(expResultGreenBall, resultGreenBall);
//    }
//
//    @Test
//    public void canPass_ONLY_ONE_MATCHING_BALL_OF_A_SEVERAL() {
//
//        // Исходные данные
//        Ball blueBall = new Ball(Color.blue);
//        Ball grayBall = new Ball(Color.gray);
//        Ball blackBall = new Ball(Color.black);
//
//        ArrayList<Color> colors = new ArrayList<>();
//        colors.add(Color.blue);
//        colors.add(Color.red);
//        colors.add(Color.green);
//        Goal goal = new Goal(colors);
//
//        // Эталонные данные
//        boolean expResultBlueBall = true;
//        boolean expResultGrayBall = false;
//        boolean expResultBlackBall = false;
//
//        // Вызов тестируемой функции
//        boolean resultBlueBall = goal.canPass(blueBall);
//        boolean resultGrayBall = goal.canPass(grayBall);
//        boolean resultBlackBall = goal.canPass(blackBall);
//
//        // Сравнение
//        Assert.assertEquals(expResultBlueBall, resultBlueBall);
//        Assert.assertEquals(expResultGrayBall, resultGrayBall);
//        Assert.assertEquals(expResultBlackBall, resultBlackBall);
//    }
//
//    @Test
//    public void canPass_ONLY_ONE_NOT_MATCHING_BALL_OF_A_SEVERAL() {
//
//        // Исходные данные
//        Ball blackBall = new Ball(Color.black);
//        Ball redBall = new Ball(Color.red);
//        Ball greenBall = new Ball(Color.green);
//
//        ArrayList<Color> colors = new ArrayList<>();
//        colors.add(Color.blue);
//        colors.add(Color.red);
//        colors.add(Color.green);
//        Goal goal = new Goal(colors);
//
//        // Эталонные данные
//        boolean expResultBlackBall = false;
//        boolean expResultRedBall = true;
//        boolean expResultGreenBall = true;
//
//        // Вызов тестируемой функции
//        boolean resultBlackBall = goal.canPass(blackBall);
//        boolean resultRedBall = goal.canPass(redBall);
//        boolean resultGreenBall = goal.canPass(greenBall);
//
//        // Сравнение
//        Assert.assertEquals(expResultBlackBall, resultBlackBall);
//        Assert.assertEquals(expResultRedBall, resultRedBall);
//        Assert.assertEquals(expResultGreenBall, resultGreenBall);
//    }
//
//    @Test
//    public void canPass_NOT_MATCHING_BALLS() {
//
//        // Исходные данные
//        Ball blackBall = new Ball(Color.black);
//        Ball grayBall = new Ball(Color.gray);
//        Ball whiteBall = new Ball(Color.white);
//
//        ArrayList<Color> colors = new ArrayList<>();
//        colors.add(Color.blue);
//        colors.add(Color.red);
//        colors.add(Color.green);
//        Goal goal = new Goal(colors);
//
//        // Эталонные данные
//        boolean expResultBlackBall = false;
//        boolean expResultGrayBall = false;
//        boolean expResultWhiteBall = false;
//
//        // Вызов тестируемой функции
//        boolean resultBlackBall = goal.canPass(blackBall);
//        boolean resultGrayBall = goal.canPass(grayBall);
//        boolean resultWhiteBall = goal.canPass(whiteBall);
//
//        // Сравнение
//        Assert.assertEquals(expResultBlackBall, resultBlackBall);
//        Assert.assertEquals(expResultGrayBall, resultGrayBall);
//        Assert.assertEquals(expResultWhiteBall, resultWhiteBall);
//    }
//}
