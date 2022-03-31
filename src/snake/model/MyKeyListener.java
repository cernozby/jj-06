package snake.model;

import snake.model.SnakeModel;
import snake.view.CentralPlayground;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter {


    CentralPlayground centralPlayground;

    public MyKeyListener(CentralPlayground centralPlayground) {
        this.centralPlayground = centralPlayground;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();
        SnakeModel snakeModel = centralPlayground.getSnakeModel();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                if(snakeModel.getActual_direction() != SnakeModel.SNAKE_DIRECTiON.DOWN) {
                    snakeModel.setActual_direction(SnakeModel.SNAKE_DIRECTiON.UP);
                }
                break;
            case KeyEvent.VK_DOWN:
                if(snakeModel.getActual_direction() != SnakeModel.SNAKE_DIRECTiON.UP) {
                    centralPlayground.getSnakeModel().setActual_direction(SnakeModel.SNAKE_DIRECTiON.DOWN);
                }
                break;
            case KeyEvent.VK_LEFT:
                if(snakeModel.getActual_direction() != SnakeModel.SNAKE_DIRECTiON.RIGHT) {
                    centralPlayground.getSnakeModel().setActual_direction(SnakeModel.SNAKE_DIRECTiON.LEFT);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(snakeModel.getActual_direction() != SnakeModel.SNAKE_DIRECTiON.LEFT) {
                    centralPlayground.getSnakeModel().setActual_direction(SnakeModel.SNAKE_DIRECTiON.RIGHT);
                }
                break;
        }
    }
}