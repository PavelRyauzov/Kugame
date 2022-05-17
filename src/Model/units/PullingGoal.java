//package Model.units;
//
//import Model.gamefield.Direction;
//
//import java.awt.*;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class PullingGoal extends MulticoloredGoal {
//
//    private Direction _pullDirection;
//
//    public PullingGoal(Color color, Direction pullDirection) {
//        super(color);
//
//        _pullDirection = pullDirection;
//
//        pullBalls();
//    }
//
//    public void pullBalls() {
//        Timer timer = new Timer();
//        TimerTask task = new PullingGoalTimerTask(timer, _pullDirection);
//
//        int delay = 100;
//        int period = 100;
//        timer.schedule(task, delay, period);
//    }
//    private class PullingGoalTimerTask extends TimerTask {
//
//        Timer _timer;
//        Direction _pullDirection;
//
//        PullingGoalTimerTask(Timer timer, Direction pullDirect) {
//
//            _timer = timer;
//            _pullDirection = pullDirect;
//        }
//
//        @Override
//        public void run() {
//
//            if (getOwner().neighbor(_pullDirection).getUnit() instanceof Ball ball) {
//                if (canPass(ball)) {
//                    takeBall(ball);
//                    ball.fireBallHasDisappeared();
//                }
//            }
//        }
//    }
//
//}
