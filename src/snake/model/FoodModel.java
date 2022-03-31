package snake.model;

import java.awt.*;
import java.util.Random;

public class FoodModel {
    private boolean exist;
    private Tail foodPosition;

    private SnakeModel snakeModel;
    public FoodModel(SnakeModel snakeModel) {
        this.snakeModel = snakeModel;
    }
    public void generateFood() {
        if(exist) {return;}
        Random rand = new Random();

        while (true) {
            Tail tail = new Tail((((rand.nextInt(33) * 20)) + 10), (((rand.nextInt(31) * 20)) + 10), Color.RED);
            if (snakeModel.getSnake().stream().noneMatch(x -> x.equals(tail))) {
                this.foodPosition = tail;
                exist = true;
                break;
            }
        }
    }

    public Tail getFood() {
        if(!exist) {
            generateFood();
        }
        return foodPosition;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}
