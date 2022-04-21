package Model.units;

import Model.Unit;
import Model.events.BallActionEvent;
import Model.events.BallActionListener;
import Model.events.GameListener;
import Model.gamefield.Cell;
import Model.gamefield.Direction;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
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

        TimerTask task = new MyTimerTask(direct, timer);

        timer.schedule(task, 100, 250);

        if (getOwner().neighbor(direct).getUnit() instanceof Goal) {
            Goal goal = (Goal) getOwner().neighbor(direct).getUnit();

            if(goal.canPass(this)) {
                goal.takeBall(this);
            }
        }

        //timer.cancel();

        //fireBallHasMoved();
    }

    public void doStep(Direction direct) {

        Cell neighborCell = getOwner().neighbor(direct);

        if (neighborCell == null) {
            return;
        }

        if (!neighborCell.isEmpty()) {
            return;
        }

        neighborCell.setUnit(getOwner().extractUnit());
    }

    private void printmsg() {
        JOptionPane.showMessageDialog(null, "Метод run", "Таймер!", JOptionPane.INFORMATION_MESSAGE);

    }

    private class MyTimerTask extends TimerTask {
        Direction direction;
        Timer _timer;

        MyTimerTask(Direction direct, Timer timer) {
            direction = direct;
            _timer = timer;
        }

        @Override
        public void run() {

            doStep(direction);

            //printmsg();
            fireBallHasAStep();

            if (!canMoveTo(getOwner().neighbor(direction))) {
                _timer.cancel();
            }
        }
    }


    // ------------------ Порождает события, связанные с движением Шарика ---------------------

    private List<BallActionListener> _listeners = new ArrayList<>();

    public void addBallActionListener(BallActionListener listener) {
        _listeners.add(listener);
    }

    public void removeBallActionListener(BallActionListener listener) {
        _listeners.remove(listener);
    }

    protected void fireBallHasMoved() {

        BallActionEvent event = new BallActionEvent(this);
        event.setBall(this);
        for (Object listener: _listeners) {
            ((BallActionListener)listener).ballHasMoved(event);
        }
    }

    protected void fireBallHasAStep() {
        BallActionEvent event = new BallActionEvent(this);
        event.setBall(this);
        for (Object listener: _listeners) {
            ((BallActionListener)listener).ballHasAStep(event);
        }
    }

    @Override
    public String toString() {
        return "B";
    }
}
