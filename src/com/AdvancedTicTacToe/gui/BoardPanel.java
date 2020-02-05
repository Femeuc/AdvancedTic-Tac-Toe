package com.AdvancedTicTacToe.gui;

import com.AdvancedTicTacToe.engine.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

public class BoardPanel extends JPanel {
    private final List<SquarePanel> boardSquares;

    private final int PANEL_WIDTH = (int) Math.floor(GameWindow.X_DIMENSION * 0.8);  // 80% of the width of the window
    private final int PANEL_HEIGHT = GameWindow.Y_DIMENSION;
    private final Dimension BOARD_PANEL_DIMENSION = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);

    public BoardPanel() {
        super(new GridLayout( Board.AMOUNT_OF_ROWS, Board.AMOUNT_OF_COLUNS));
        this.boardSquares = new ArrayList<>();
        for(int i = 0; i < Board.AMOUNT_OF_SQUARES; i++) {
            SquarePanel squarePanel = new SquarePanel(i);
            this.boardSquares.add(squarePanel);
            add(squarePanel);
        }
        setPreferredSize(BOARD_PANEL_DIMENSION);
        validate();
    }

    public void drawOnSquare(int squareId) {
        for (SquarePanel squarePanel : boardSquares) {
            if(squarePanel.squareId == squareId) {
                squarePanel.drawOnThisSquare();
            }
        }
        validate();
        repaint();
    }

    private class SquarePanel extends JPanel {
        private final Dimension SQUARE_PANEL_DIMENSION = new Dimension(10, 10);
        private final Color darkColor = new Color(50, 50, 50);
        private final Color brightColor = new Color(200, 200, 200);
        private final int squareId;

        SquarePanel(int squareId) {
            super(new GridBagLayout());
            this.squareId = squareId;
            setPreferredSize(SQUARE_PANEL_DIMENSION);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            assignSquareColor();
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    if(isRightMouseButton(mouseEvent) || isLeftMouseButton(mouseEvent)) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                drawOnSquare(squareId);
                            }
                        });
                    }
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
        }

        private void assignSquareColor() {
            setBackground(this.squareId % 2 == 0 ? brightColor : darkColor);
        }

        public void drawOnThisSquare() {
            ImageIcon icon = new ImageIcon("src/smallCross.PNG");
            JLabel symbol = new JLabel(icon);
            add(symbol);
        }

    }

}
