package snake.view;

import snake.model.MyKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
    private final JPanel mainPanel = new JPanel();
    private final JPanel subPanelBottom = new JPanel();
    private final CentralPlayground centerPlayground = new CentralPlayground();


    private final JButton startButton = new JButton("Start");
    private final JButton endButton = new JButton("End");

    public MainView() {
        this.pageSetting();

    }

    void pageSetting() {
        mainPanel.setLayout(new BorderLayout());
        startButton.setFocusable(false);
        endButton.setFocusable(false);
        setPreferredSize(new Dimension(696, 715));
        getContentPane().add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFocusable(true);
        requestFocusInWindow();
        pack();

        this.setLocationRelativeTo(null);
        this.addComponents();

    }

    void addComponents() {
        subPanelBottom.add(startButton);
        subPanelBottom.add(endButton);
        this.mainPanel.add(centerPlayground, BorderLayout.CENTER);
        this.mainPanel.add(subPanelBottom, BorderLayout.SOUTH);
        startButton.addActionListener(this::actionPerformedStart);
        endButton.addActionListener(this::actionPerformedEnd);
        addKeyListener(new MyKeyListener(this.getCenterPlayground()));
    }

    private void actionPerformedStart(ActionEvent actionEvent) {
        Thread thread = new Thread(() -> getCenterPlayground().startGame());
        thread.start();
    }

    private void actionPerformedEnd(ActionEvent actionEvent) {
        this.getCenterPlayground().setGame_flag(CentralPlayground.GAME.END);
    }

    public CentralPlayground getCenterPlayground() {
        return centerPlayground;
    }
}

