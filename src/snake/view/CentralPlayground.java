package snake.view;

import snake.model.FoodModel;
import snake.model.SnakeModel;
import snake.model.Tail;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CentralPlayground extends JPanel implements ActionListener {


    private final Rectangle square = new Rectangle();
    private final SnakeModel snakeModel = new SnakeModel();
    private Timer timer;

    public enum GAME {START, GAME, END}
    private GAME game_flag = GAME.START;

    public CentralPlayground() {
        setBackground(Color.gray);
        setBorder(BorderFactory.createLineBorder(Color.black, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setFont(g2d.getFont().deriveFont(20f));
        g2d.setColor(Color.WHITE);
        g2d.drawString("POINTS: " + snakeModel.getPoints(), 30, 30);

        for (Tail tail: snakeModel.getSnake()) {
            g2d.setColor(tail.getColor());
            square.setBounds(tail.getPosition_x(), tail.getPosition_y(), 20, 20);
            g2d.fill(square);
        }

        g2d.setColor(Color.RED);
        Tail foodTail = snakeModel.getFoodModel().getFood();
        square.setBounds(foodTail.getPosition_x(), foodTail.getPosition_y(), 20, 20);
        g2d.fill(square);

        if(this.game_flag.equals(GAME.END)) {
            g2d.setFont(g2d.getFont().deriveFont(40f));
            g2d.setColor(Color.white);
            g2d.drawString("GAME OVER", this.getWidth() / 2 - 100, 100);
        }
    }

    public void startGame() {
        game_flag = GAME.GAME;
        timer = new Timer(160,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if(game_flag.equals(GAME.GAME)) {
            if (!snakeModel.moveSnake()) {
                this.game_flag =GAME.END;
            }
            snakeModel.generateFood();
            repaint();
        } else {
            snakeModel.resetGame();
            repaint();
            timer.stop();
        }
    }

    public SnakeModel getSnakeModel() {
        return snakeModel;
    }


    public void setGame_flag(GAME game_flag) {
        this.game_flag = game_flag;
    }
}
