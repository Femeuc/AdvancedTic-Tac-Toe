package com.AdvancedTicTacToe.gui;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    private final int PANEL_WIDTH = (int) Math.floor(GameWindow.X_DIMENSION * 0.2);
    private final int PANEL_HEIGHT = GameWindow.Y_DIMENSION;
    private final Dimension LEFT_PANEL_DIMENSION = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
    private final Dimension LEFT_PANEL_TOP_DIMENSION = new Dimension(PANEL_WIDTH, PANEL_HEIGHT/2);
    private final Dimension LEFT_PANEL_BOTTOM_DIMENSION = new Dimension(PANEL_WIDTH, PANEL_HEIGHT/2);

    public LeftPanel() {
        super(new GridLayout(2, 1));
        LeftPanelTop lpTop = new LeftPanelTop();
        LeftPanelBottom lpBottom = new LeftPanelBottom();
        setPreferredSize(LEFT_PANEL_DIMENSION);
        add(lpTop);
        add(lpBottom);
        validate();
    }

    private class LeftPanelTop extends JPanel {
        //TODO correct the images
        ImageIcon crossImage = new ImageIcon("src/crossImage.PNG");
        JLabel circleTurnLabel = new JLabel("Vez de", crossImage, JLabel.CENTER);
        JLabel crossTurnLabel = new JLabel("Vez de", crossImage, JLabel.CENTER);


        LeftPanelTop() {
            super(new BorderLayout());
            setPreferredSize(LEFT_PANEL_TOP_DIMENSION);
            setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
            circleTurnLabel.setHorizontalTextPosition(JLabel.CENTER);
            circleTurnLabel.setVerticalTextPosition(JLabel.TOP);
            crossTurnLabel.setHorizontalTextPosition(JLabel.CENTER);
            crossTurnLabel.setVerticalTextPosition(JLabel.TOP);
            JPanel container = new JPanel(new GridLayout(2, 1));  // The only purpose of this container is to help to layout these two labels
            add(container, BorderLayout.CENTER);
            container.add(circleTurnLabel);
            container.add(crossTurnLabel);
        }
    }

    private class LeftPanelBottom extends JPanel {

        LeftPanelBottom() {
            super(new BorderLayout());
            setPreferredSize(LEFT_PANEL_BOTTOM_DIMENSION);
            setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
        }
    }

}
