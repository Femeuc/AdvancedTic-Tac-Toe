package com.AdvancedTicTacToe.gui;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    private final JFrame gameFrame;
    private final String GAME_TITLE = "Advanced Tic-Tac-Toe";

    private final Dimension WINDOW_DIMENSION = new Dimension(600, 600);

    private final BoardPanel boardPanel;

    public GameWindow() {
        this.gameFrame = new JFrame(GAME_TITLE);
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setSize(WINDOW_DIMENSION);
        this.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.boardPanel = new BoardPanel();
        this.gameFrame.add(boardPanel, BorderLayout.CENTER);
        this.gameFrame.setVisible(true);
    }
}
