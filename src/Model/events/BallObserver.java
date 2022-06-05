package Model.events;

import Model.Game;
import Model.gamefield.Direction;
import Model.units.MulticoloredGoal;
import Model.units.PullingGoal;

// Слушатель событий связанных с действиями шарика
public class BallObserver implements BallActionListener {
    Object _observerObject;
    public BallObserver(Object observerObject) {
        _observerObject = observerObject;
    }
    @Override
    public void ballHasAStep(BallActionEvent e) {

        if (_observerObject instanceof Game game) {
            game.ballActionCreator().fireBallHasAStep(e.ball(), e.direction());
        }

        if (_observerObject instanceof PullingGoal goal) {
            if (goal.getOwner().isNeighbor(e.ball().getOwner())) {
                ballHasAMoved(e);
            }
        }
    }

    @Override
    public void ballHasAMoved(BallActionEvent e) {

        if (_observerObject instanceof Game game) {
            if(e.ball().getOwner() == null) {
                game.field().deleteBall(e.ball());
            }

            if (game.field().balls().isEmpty()) {
                game.fireGameFinished();
            }

            game.ballActionCreator().fireBallHasAMoved(e.ball(), e.direction());
        }

        if (_observerObject instanceof MulticoloredGoal goal) {
            if (e.ball().getOwner() != null) {
                if (e.ball().getOwner().neighbor(e.direction()) == goal.getOwner()) {
                    goal.takeBall(e.ball());
                }
            }
        }

        if (_observerObject instanceof PullingGoal goal) {
            if (e.ball().getOwner() != null) {
                if (goal.getOwner().isNeighbor(e.ball().getOwner())) {
                    goal.takeBall(e.ball());
                }
            }
        }
    }
}
