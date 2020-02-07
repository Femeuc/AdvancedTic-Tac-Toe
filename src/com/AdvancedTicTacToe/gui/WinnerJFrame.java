package com.AdvancedTicTacToe.gui;

import com.AdvancedTicTacToe.engine.Alliance;

import javax.swing.*;
import java.awt.*;

public class WinnerJFrame {
    private final JFrame winnerFrame;
    private final String JFRAMETITLE = "VENCEDOR";
    public static final int X_DIMENSION = 300;
    public static final int Y_DIMENSION = 250;
    private final Dimension WINDOW_DIMENSION = new Dimension(X_DIMENSION, Y_DIMENSION);

    private final MessagePanel winnerPanel;

    public WinnerJFrame(Alliance winner) {
        this.winnerFrame = new JFrame(JFRAMETITLE);
        this.winnerFrame.setLayout(new BorderLayout());
        this.winnerFrame.setSize(WINDOW_DIMENSION);
        this.winnerPanel = new MessagePanel(winner);
        this.winnerFrame.add(winnerPanel, BorderLayout.CENTER);
        this.winnerFrame.setResizable(false);
        this.winnerFrame.setVisible(true);
    }

    private class MessagePanel extends JPanel {

        MessagePanel(Alliance winner) {
            super(new BorderLayout());
            JLabel winnerMessage = new JLabel("<html><p style='text-align:center;'>O vencedor é <br>" + winner.toString() + " <br>PARABÉNS!!!</p></html>"); //TODO testar depois sem esse text align
            winnerMessage.setHorizontalAlignment(JLabel.CENTER);
            winnerMessage.setVerticalAlignment(JLabel.CENTER);
            winnerMessage.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            add(winnerMessage, BorderLayout.CENTER);
        }
    }
}
