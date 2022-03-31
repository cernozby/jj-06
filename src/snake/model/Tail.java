package snake.model;

import java.awt.*;
import java.util.Objects;

public class Tail {
    private int position_x;
    private int position_y;
    private Color color;

    Tail(int position_x, int position_y, Color color) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.color = color;
    }

    public void addToPositionX(int num) {
        this.position_x += num;
    }

    public void addToPositionY(int num) {
        this.position_y += num;
    }

    public void setPosition_x(int num) {
        this.position_x = num;
    }

    public void setPosition_y(int num) {
        this.position_y = num;
    }

    public int getPosition_x() {
        return position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tail tail = (Tail) o;
        return position_x == tail.position_x && position_y == tail.position_y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position_x, position_y);
    }

}
