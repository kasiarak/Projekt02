package pres;

import game.Board;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MainPanel extends JPanel {
    public JTable roadTable;
    public int carPosition = 1;
    public int[][] gameBoard;
    RoadPanel roadPanel;
    JPanel scorePanel;
    public SevenSegmentDigit unity;
    public SevenSegmentDigit tens;
    public SevenSegmentDigit hundreds;

    public MainPanel() {
        gameBoard = new int[7][3];
        gameBoard[0][1] = 1;
        Board board = new Board(this);
        this.addKeyListener(board);
        this.setFocusable(true);
        this.setLayout(new BorderLayout());

        roadTable = new JTable(7, 1);
        roadTable.setEnabled(false);
        roadTable.setRowHeight(38);
        roadTable.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                if (column == 0) {
//                    JLabel label = new JLabel();
//                    label.setOpaque(true);
//                    label.setBackground(Color.BLACK);
//                    return label;
//                } else if (column == 4) {
//                    JLabel label = new JLabel();
//                    label.setOpaque(true);
//                    label.setBackground(Color.BLACK);
//                    return label;
//                } else if (column == carPosition+1 && row == 6) {
//                    JPanel car = new JPanel(new FlowLayout(FlowLayout.CENTER));
//                    car.setBackground(Color.orange);
//                    JLabel label = new JLabel();
//                    car.add(label);
//                    JPanel container = new JPanel(new BorderLayout());
//                    container.setBorder(BorderFactory.createEmptyBorder(5, 13, 5, 13));
//                    container.setBackground(table.getBackground());
//                    container.add(car, BorderLayout.CENTER);
//                    return container;
//                }
//                else if(gameBoard[6-row][column-1] == 1){
//                    JPanel container = new JPanel(new BorderLayout());
//                    JLabel label = new JLabel();
//                    label.setOpaque(true);
//                    label.setBackground(Color.BLACK);
//                    container.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
//                    container.setBackground(table.getBackground());
//                    container.add(label, BorderLayout.CENTER);
//                    return container;
//                }else {
//                    return new JLabel();
//                }
                if(row==0){
                    ImageIcon img = new ImageIcon("");
                    JLabel jLabel = new JLabel();
                    jLabel.setIcon(img);
                    jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                    return jLabel;
                }else return new JLabel();
            }
        });

        scorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        unity = new SevenSegmentDigit();
        tens = new SevenSegmentDigit();
        hundreds = new SevenSegmentDigit();
        unity.addDigitListener(tens);
        tens.addDigitListener(hundreds);
        scorePanel.add(hundreds);
        scorePanel.add(tens);
        scorePanel.add(unity);

        roadPanel = new RoadPanel();
        roadPanel.setLayout(null);

        roadPanel.add(scorePanel);
        roadPanel.add(roadTable);
        this.add(roadPanel, BorderLayout.CENTER);
    }
    public void updateView(){
        roadTable.repaint();
    }

    class RoadPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int roadWidth = 327;
            int roadHeight = panelHeight;

            g.setColor(Color.GREEN);
            g.fillRect(0, 0, panelWidth, panelHeight);

            g.setColor(Color.RED);
            g.fillRect(150, 0, 20, panelHeight);
            g.fillRect(panelWidth - 90, 0, 20, panelHeight);

            scorePanel.setBounds(0,0, 145, 70);
            scorePanel.setBackground(Color.GREEN);
            roadTable.setBounds(170, 0, roadWidth, roadHeight);
        }
    }
}