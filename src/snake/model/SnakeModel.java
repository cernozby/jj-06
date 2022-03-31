package snake.model;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeModel {


    public enum SNAKE_DIRECTiON {UP, RIGHT, DOWN, LEFT}
    private LinkedList<Tail> snake = new LinkedList<>();
    private SNAKE_DIRECTiON actual_direction;
    private static final int STEP = 20;
    private static final Color HEAD = Color.YELLOW;
    private static final Color BODY = Color.GREEN;
    private int points = 0;
    private FoodModel foodModel = new FoodModel(this);


    public SnakeModel() {
        this.actual_direction = SNAKE_DIRECTiON.DOWN;
        setStartSnakePosition();

    }

    private void setStartSnakePosition() {
        snake.removeIf(x -> true);
        snake.add(new Tail(110, 110, HEAD));
        snake.add(new Tail(130, 110, BODY));
        snake.add(new Tail(150, 110, BODY));


    }

    public void resetGame() {
        this.points = 0;
        this.foodModel.setExist(false);
        this.setStartSnakePosition();
    }

    public boolean moveSnake() {
        Tail tail = new Tail(snake.getFirst().getPosition_x(), snake.getFirst().getPosition_y(), HEAD);

        switch (actual_direction) {
            case UP:
                tail.addToPositionY(-1 * STEP);
                if (tail.getPosition_y() < 10) {tail.setPosition_y(610);}
                break;
            case RIGHT:
                    tail.addToPositionX(STEP);
                    if(tail.getPosition_x() > 650) {tail.setPosition_x(10);}
                break;
            case DOWN:
                    tail.addToPositionY(STEP);
                    if(tail.getPosition_y() > 610) {tail.setPosition_y(10);}
                break;
            case LEFT:
                    tail.addToPositionX(-1 * STEP);
                    if(tail.getPosition_x() < 10) {tail.setPosition_x(650);}
                break;
        }

        if (snake.stream().anyMatch(x -> x.equals(tail))) {
            return false;
        }
        snake.addFirst(tail);
        snake.get(1).setColor(BODY);
        return true;



    }

    public void generateFood() {
        if (snake.getFirst().equals(foodModel.getFood())) {
            foodModel.setExist(false);
            points += 10;
        } else {
            snake.removeLast();
        }
    }

    public LinkedList<Tail> getSnake() {
        return snake;
    }

    public FoodModel getFoodModel() {
        return this.foodModel;
    }

    public void setActual_direction(SNAKE_DIRECTiON actual_direction) {
        this.actual_direction = actual_direction;
    }

    public SNAKE_DIRECTiON getActual_direction() {
        return this.actual_direction;
    }

    public int getPoints() {
        return points;
    }
}
