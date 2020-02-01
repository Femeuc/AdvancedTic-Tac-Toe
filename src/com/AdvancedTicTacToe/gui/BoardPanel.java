package com.AdvancedTicTacToe.gui;

import com.AdvancedTicTacToe.engine.Board;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardPanel extends JPanel {
    private final List<SquarePanel> boardSquares;
    private final Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);

    public BoardPanel() {
        super(new GridLayout(8, 8));
        this.boardSquares = new ArrayList<>();
        for(int i = 0; i < Board.AMOUNT_OF_SQUARES; i++) {
            SquarePanel squarePanel = new SquarePanel(this, i);
            this.boardSquares.add(squarePanel);
            add(squarePanel);
        }
        setPreferredSize(BOARD_PANEL_DIMENSION);
        validate();
    }

    public void drawBoard() {
        validate();
        repaint();
    }

    private class SquarePanel extends JPanel {
        private final Dimension SQUARE_PANEL_DIMENSION = new Dimension(10, 10);
        private final Color darkColor = new Color(50, 50, 50);
        private final Color brightColor = new Color(200, 200, 200);

        private final int squareId;

        SquarePanel(BoardPanel boardPanel, int squareId) {
            super(new GridBagLayout());
            this.squareId = squareId;
            setPreferredSize(SQUARE_PANEL_DIMENSION);
            assignSquareColor();
        }

        private void assignSquareColor() {
            setBackground(this.squareId % 2 == 0 ? brightColor : darkColor);
        }

        public void drawSquare() {
            validate();
            repaint();
        }
    }
}
