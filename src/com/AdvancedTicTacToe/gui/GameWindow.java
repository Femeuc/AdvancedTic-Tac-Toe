package com.AdvancedTicTacToe.gui;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private final JFrame gameFrame;
    private final String GAME_TITLE = "Advanced Tic-Tac-Toe";

    public static final int X_DIMENSION = 800;
    public static final int Y_DIMENSION = 600;
    private final Dimension WINDOW_DIMENSION = new Dimension(X_DIMENSION, Y_DIMENSION);

    private final BoardPanel boardPanel;
    private final LeftPanel leftPanel;

    public GameWindow() {
        this.gameFrame = new JFrame(GAME_TITLE);
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setSize(WINDOW_DIMENSION);
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.boardPanel = new BoardPanel();
        this.leftPanel = new LeftPanel();
        this.gameFrame.add(boardPanel, BorderLayout.CENTER);
        this.gameFrame.add(leftPanel, BorderLayout.WEST);
        this.gameFrame.setVisible(true);
    }
}
