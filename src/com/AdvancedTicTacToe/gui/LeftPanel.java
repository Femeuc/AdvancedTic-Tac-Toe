package com.AdvancedTicTacToe.gui;

import com.AdvancedTicTacToe.engine.Alliance;
import com.AdvancedTicTacToe.engine.Board;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LeftPanel extends JPanel {

    private static LeftPanelTop lpTop;
    private static LeftPanelBottom lpBottom;

    private final int PANEL_WIDTH = (int) Math.floor(GameWindow.X_DIMENSION * 0.2);  // 20% of the width of the window
    private final int PANEL_HEIGHT = GameWindow.Y_DIMENSION;
    private final Dimension LEFT_PANEL_DIMENSION = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
    private final Dimension LEFT_PANEL_TOP_DIMENSION = new Dimension(PANEL_WIDTH, PANEL_HEIGHT/2);
    private final Dimension LEFT_PANEL_BOTTOM_DIMENSION = new Dimension(PANEL_WIDTH, PANEL_HEIGHT/2);
    private static Border playerTurnHighlight = BorderFactory.createLineBorder(new Color(0, 255, 0));
//    private static String unnocupiedSquaresNumber = "";  TODO maybe I should delete this
    public LeftPanel() {
        super(new GridLayout(2, 1));
        lpTop = new LeftPanelTop();
        lpBottom = new LeftPanelBottom();
        setPreferredSize(LEFT_PANEL_DIMENSION);
        add(lpTop);
        add(lpBottom);
        validate();
    }

    private class LeftPanelTop extends JPanel {
        ImageIcon crossImage = new ImageIcon("src/crossImage.PNG");
        ImageIcon circleImage = new ImageIcon("src/circleImage.PNG");
        JLabel circleTurnLabel = new JLabel("Vez de", circleImage, JLabel.CENTER);
        JLabel crossTurnLabel = new JLabel("Vez de", crossImage, JLabel.CENTER);
        JPanel container;

        LeftPanelTop() {
            super(new BorderLayout());
            setPreferredSize(LEFT_PANEL_TOP_DIMENSION);
            setup();
        }

        private void setup() {
            setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
            circleTurnLabel.setHorizontalTextPosition(JLabel.CENTER);
            circleTurnLabel.setVerticalTextPosition(JLabel.TOP);
            crossTurnLabel.setHorizontalTextPosition(JLabel.CENTER);
            crossTurnLabel.setVerticalTextPosition(JLabel.TOP);
            highlightPlayerTurnAlliance();
            container = new JPanel(new GridLayout(2, 1));  // The only purpose of this container is to help to layout these two labels
            add(container, BorderLayout.CENTER);
            container.add(crossTurnLabel);
            container.add(circleTurnLabel);
        }

        private void highlightPlayerTurnAlliance() {
            Alliance allianceToHighlight = BoardPanel.getMatch().getAlliance();
            if(allianceToHighlight.isCross()) {
                circleTurnLabel.setBorder(null);
                crossTurnLabel.setBorder(playerTurnHighlight);
            }
            if(allianceToHighlight.isCircle()) {
                crossTurnLabel.setBorder(null);
                circleTurnLabel.setBorder(playerTurnHighlight);
            }
        }

    }

    private class LeftPanelBottom extends JPanel {
        private JLabel unoccupiedSquaresLabel = new JLabel("<html><p style='text-align:center;'>Quadrados <br>vazios</p></html>");
        private JTextField unoccupiedSquaresField = new JTextField();
        private JLabel occupiedSquaresLabel = new JLabel("<html><p style='text-align:center;'>Quadrados <br>ocupados</p></html>");
        private JTextField occupiedSquaresField = new JTextField();

        LeftPanelBottom() {
            super(new BorderLayout());
            setPreferredSize(LEFT_PANEL_BOTTOM_DIMENSION);
            setup();
        }

        private void setup() {
            JPanel container1 = new JPanel(new GridLayout(2, 1));  // These containers
            JPanel container2 = new JPanel(new GridBagLayout());         // are used only
            JPanel container3 = new JPanel(new GridBagLayout());         // for layout purposes
            GridBagConstraints c = new GridBagConstraints();
            c.insets = new Insets(12, 12, 12, 12);
            c.ipadx = 10;
            c.ipady = 10;
            c.anchor = GridBagConstraints.CENTER;
            container1.add(container2);
            container1.add(container3);
            unoccupiedSquaresField.setEditable(false);
            occupiedSquaresField.setEditable(false);
            unoccupiedSquaresField.setPreferredSize(new Dimension(30, 20));
            occupiedSquaresField.setPreferredSize(new Dimension(30, 20));
            container2.add(unoccupiedSquaresLabel);
            container2.add(unoccupiedSquaresField, c);
            container3.add(occupiedSquaresLabel);
            container3.add(occupiedSquaresField, c);
            add(container1, BorderLayout.CENTER);
        }

        public void setUnoccupiedSquaresField(String str) {
            this.unoccupiedSquaresField.setText(str);
            this.unoccupiedSquaresField.setHorizontalAlignment(JTextField.CENTER);
        }

        public void setOccupiedSquaresField(String str) {
            this.occupiedSquaresField.setText(str);
            this.occupiedSquaresField.setHorizontalAlignment(JTextField.CENTER);
        }
    }

    public static void switchPlayerTurnHighlight() {
       lpTop.highlightPlayerTurnAlliance();
    }

    public static void updateLeftPanelBottom(String unnocupiedSquaresNumber, String occupiedSquaresNumber) {
        lpBottom.setUnoccupiedSquaresField(unnocupiedSquaresNumber);
        lpBottom.setOccupiedSquaresField(occupiedSquaresNumber);
    }
}
