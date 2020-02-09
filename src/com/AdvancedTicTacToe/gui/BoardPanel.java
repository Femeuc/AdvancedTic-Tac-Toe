package com.AdvancedTicTacToe.gui;

import com.AdvancedTicTacToe.engine.Board;
import com.AdvancedTicTacToe.engine.Match;

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

    private static Match match = new Match();

    public BoardPanel() {
        super(new GridLayout( Board.AMOUNT_OF_ROWS, Board.AMOUNT_OF_COLUNS));
        this.boardSquares = new ArrayList<>();
        for(int i = 0; i < Board.AMOUNT_OF_SQUARES; i++) {
            SquarePanel squarePanel = new SquarePanel(i);
            this.boardSquares.add(squarePanel);
            add(squarePanel);
        }
        LeftPanel.updateLeftPanelBottom( Integer.toString(match.getUnoccupiedSquaresNumber()), Integer.toString(match.getOccupiedSquaresNumber()));
        setPreferredSize(BOARD_PANEL_DIMENSION);
        validate();
    }

    private class SquarePanel extends JPanel {
        private final Dimension SQUARE_PANEL_DIMENSION = new Dimension(10, 10);
        private final int squareId;

        SquarePanel(int squareId) {
            super(new GridBagLayout());
            this.squareId = squareId;
            setPreferredSize(SQUARE_PANEL_DIMENSION);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    if((isRightMouseButton(mouseEvent) || isLeftMouseButton(mouseEvent)) && !match.getBoard().gameBoard[squareId].isOccupied() ){
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                drawOnSquare(squareId);
                                if(match.occupyGameBoardSquare(squareId)) {
                                    System.out.println("O VENCEDOR É " + match.getWinner().toString()); // If there's a winner
                                    new WinnerJFrame(match.getWinner());
                                }
                                LeftPanel.updateLeftPanelBottom( Integer.toString(match.getUnoccupiedSquaresNumber()), Integer.toString(match.getOccupiedSquaresNumber()));
                                LeftPanel.switchPlayerTurnHighlight();
                            }
                        });
                    } else {
                        System.out.println("QUADRADO OCUPADO!");
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

        public void drawOnThisSquare() {
            String whichIcon = match.getAlliance().isCross() ? "smallCross.PNG" : "smallCircle.PNG";
            ImageIcon icon = new ImageIcon("src/" + whichIcon);
            JLabel symbol = new JLabel(icon);
            add(symbol);
        }

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

    public static Match getMatch() {
        return match;
    }

}
