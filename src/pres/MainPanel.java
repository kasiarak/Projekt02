package pres;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
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
        roadTable = new JTable(5, 5);
        roadTable.setEnabled(false);
        roadTable.setRowHeight(73);
        roadTable.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (column == 0) {
                    JLabel label = new JLabel();
                    label.setOpaque(true);
                    label.setBackground(Color.BLACK);
                    return label;
                } else if (column == 4) {
                    JLabel label = new JLabel();
                    label.setOpaque(true);
                    label.setBackground(Color.BLACK);
                    return label;
                } else if (column == 2 && row == 3) {
                    JPanel car = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    car.setBackground(Color.orange);
                    JLabel label = new JLabel();
                    car.add(label);

                    JPanel container = new JPanel(new BorderLayout());
                    container.setBorder(BorderFactory.createEmptyBorder(13, 13, 13, 13));
                    container.setBackground(table.getBackground());
                    container.add(car, BorderLayout.CENTER);

                    return container;
                } else {
                    return new JLabel();
                }
            }
        });

        roadPanel = new RoadPanel();
        roadPanel.setLayout(null);

        roadPanel.add(roadTable);
        this.add(roadPanel, BorderLayout.CENTER);

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
            int roadWidth = panelWidth - 340;
            int roadHeight = panelHeight;

            g.setColor(Color.GREEN);
            g.fillRect(0, 0, panelWidth, panelHeight);

            g.setColor(Color.RED);
            g.fillRect(150, 0, 20, panelHeight);
            g.fillRect(panelWidth - 170, 0, 20, panelHeight);

            roadTable.setBounds(170, 0, roadWidth, roadHeight);
        }
    }
}