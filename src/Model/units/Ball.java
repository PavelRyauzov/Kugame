package Model.units;

import Model.Unit;
import Model.events.BallActionCreator;
import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.gamefield.Cell;
import Model.gamefield.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Ball extends Unit {

    // ---------------------- Свойства ---------------------

    private Color _color;

    public Color color() { return _color; }


    // --------------------- Порождение --------------------

    public Ball(Color color) { _color = color; }


    // -------------------- Перемещение --------------------

    public boolean canMoveTo(Cell cell) { return cell.isEmpty(); }

    public void move(Direction direct) {

        Timer timer = new Timer();
        TimerTask task = new BallTimerTask(timer, this, direct);

        int delay = 100;
        int period = 100;
        timer.schedule(task, delay, period);
    }

    private class BallTimerTask extends TimerTask {

        Timer _timer;
        Ball _ball;
        Direction _direction;

        BallTimerTask(Timer timer, Ball ball, Direction direct) {

            _timer = timer;
            _ball = ball;
            _direction = direct;
        }

        @Override
        public void run() {

//            if(getOwner() == null) {
//                _timer.cancel();
//                fireBallHasAStep();
//                fireBallHasDisappeared();
//                fireBallHasAMoved();
//                return;
//            }

            if (canMoveTo(getOwner().neighbor(_direction))) {
                doStep(_direction);
            } else {
                _timer.cancel();

                ballActionCreator().fireBallHasAMoved(this._ball, _direction);
            }
        }
    }

    private void doStep(Direction direct) {

        Cell neighborCell = getOwner().neighbor(direct);

        if (neighborCell == null) {
            return;
        }

        if (!neighborCell.isEmpty()) {
            return;
        }

        neighborCell.setUnit(getOwner().extractUnit());

        ballActionCreator().fireBallHasAStep(this);
    }

    // ------------------ Порождает события, связанные с движением Шарика ---------------------
    private BallActionCreator _ballActionCreator = new BallActionCreator();
    public BallActionCreator ballActionCreator() { return _ballActionCreator; }

    @Override
    public String toString() {
        return "B";
    }
}
