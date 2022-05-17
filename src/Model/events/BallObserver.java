package Model.events;

import Model.Game;
import Model.gamefield.Direction;
import Model.units.MulticoloredGoal;

// Слушатель событий связанных с действиями шарика
public class BallObserver implements BallActionListener {

    Object _observerObject;

    public BallObserver(Object observerObject) {
        _observerObject = observerObject;
    }
    @Override
    public void ballHasAStep(BallActionEvent e) {

        if (_observerObject instanceof Game game) {
            game.ballActionCreator().fireBallHasAStep(e.ball());
        }

        if (_observerObject instanceof MulticoloredGoal goal) {

        }
    }

    @Override
    public void ballHasAMoved(BallActionEvent e, Direction direction) {

        if (_observerObject instanceof Game game) {
            if(e.ball().getOwner() == null) {
                game.field().deleteBall(e.ball());
            }

            if (game.field().balls().isEmpty()) {
                game.fireGameFinished();
            }

            game.ballActionCreator().fireBallHasAMoved(e.ball(), direction);
        }

        if (_observerObject instanceof MulticoloredGoal goal) {
            if (e.ball().getOwner() != null) {
                if (e.ball().getOwner().neighbor(direction) == goal.getOwner()) {
                    if (goal.canPass(e.ball())) {
                        goal.takeBall(e.ball());
                    }
                }
            }
        }
    }
}
