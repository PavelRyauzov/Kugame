package Model.units;

import java.awt.*;
import java.util.ArrayList;

public class MulticoloredGoal extends Goal {

    ArrayList<Color> _colors = new ArrayList<>();

    public ArrayList<Color> colors() {
        return _colors;
    }

    public MulticoloredGoal(ArrayList<Color> colors) {
        super();
        _colors = colors;
    }

    public void addColor(Color color) {
        _colors.add(color);
    }

    @Override
    public boolean canPass(Ball ball) {
        return _colors.contains(ball.color());
    }
}

// Тесты
// 1. Один шарик подходит / не подходит
// 2. Несколько шариков - все подходят
// 3. Несколько шариков - один подходит, другие нет
// 4. Несколько шариков - один не подходит, другие да
// 5. Несколько шариков - ни один не подходит
