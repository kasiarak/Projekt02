package pres;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    JTable roadTable;
    RoadPanel roadPanel;
    JPanel scorePanel;
    SevenSegmentDigit unity;
    SevenSegmentDigit tens;
    SevenSegmentDigit hundreds;

    public MainPanel() {
        this.setLayout(new BorderLayout());

        // Road Table
        roadTable = new JTable(7, 5);
        roadTable.setEnabled(false);
        roadTable.setRowHeight(50); // Ustaw wysokość wiersza

        // Road Panel
        roadPanel = new RoadPanel();
        roadPanel.setLayout(null); // Używamy null layout, aby ręcznie zarządzać pozycją komponentów

        // Dodajemy roadTable do roadPanel
        roadPanel.add(roadTable);
        this.add(roadPanel, BorderLayout.CENTER);

        // Score Panel
        scorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        unity = new SevenSegmentDigit();
        tens = new SevenSegmentDigit();
        hundreds = new SevenSegmentDigit();
        scorePanel.add(hundreds);
        scorePanel.add(tens);
        scorePanel.add(unity);
        this.add(scorePanel, BorderLayout.NORTH);
    }

    void updateScore(int score) {
        unity.setValue(score % 10);
        tens.setValue((score / 10) % 10);
        hundreds.setValue((score / 100) % 10);
    }

    class RoadPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int roadWidth = panelWidth - 240;
            int roadHeight = panelHeight;

            // Green roadside
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, panelWidth, panelHeight);

            // Red lines
            g.setColor(Color.RED);
            g.fillRect(100, 0, 20, panelHeight);
            g.fillRect(panelWidth - 120, 0, 20, panelHeight);

            // Adjust JTable position and size
            roadTable.setBounds(120, 0, roadWidth, roadHeight);
        }
    }
}