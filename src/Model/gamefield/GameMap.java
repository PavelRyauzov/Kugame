package Model.gamefield;

public interface GameMap {

    public GameMap createField();
    public GameMap seedBarriers();
    public GameMap seedBalls();
    public GameMap seedGoals();

    public GameField build();
}
