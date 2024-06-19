package pres;

import game.Board;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MainPanel extends JPanel {
    public JTable roadTable;
    public int[] gameBoard;
    RoadPanel roadPanel;
    JPanel scorePanel;
    public SevenSegmentDigit unity;
    public SevenSegmentDigit tens;
    public SevenSegmentDigit hundreds;

    public MainPanel() {
        gameBoard = new int[7];
        gameBoard[0] = 2;
        Board board = new Board(this);
        this.addKeyListener(board);
        this.setFocusable(true);
        this.setLayout(new BorderLayout());

        roadTable = new RoadTable(7,1);
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
                if(row==6){
                    ImageIcon img = null;
                    JLabel jLabel = new JLabel();
                    if(gameBoard[0]==2) img = new ImageIcon("images/Car Center.png");
                    if(gameBoard[0]==4) img = new ImageIcon("images/Car Left.png");
                    if(gameBoard[0]==1) img = new ImageIcon("images/Car Right.png");
                    jLabel.setIcon(img);
                    return jLabel;
                }else if(row==5){
                    ImageIcon img = null;
                    JLabel jLabel = new JLabel();
                    if(gameBoard[1]==0) img = new ImageIcon("images/Row 1 empty.png");
                    if(gameBoard[1]==1) img = new ImageIcon("images/Row 1 right.png");
                    if(gameBoard[1]==2) img = new ImageIcon("images/Row 1 center.png");
                    if(gameBoard[1]==3) img = new ImageIcon("images/Row 1 center right.png");
                    if(gameBoard[1]==4) img = new ImageIcon("images/Row 1 left.png");
                    if(gameBoard[1]==5) img = new ImageIcon("images/Row 1 left right.png");
                    if(gameBoard[1]==6) img = new ImageIcon("images/Row 1 left center.png");
                    jLabel.setIcon(img);
                    return jLabel;
                }else if(row==4){
                    ImageIcon img = null;
                    JLabel jLabel = new JLabel();
                    if(gameBoard[2]==0) img = new ImageIcon("images/Row 2 empty.png");
                    if(gameBoard[2]==1) img = new ImageIcon("images/Row 2 right.png");
                    if(gameBoard[2]==2) img = new ImageIcon("images/Row 2 center.png");
                    if(gameBoard[2]==3) img = new ImageIcon("images/Row 2 center right.png");
                    if(gameBoard[2]==4) img = new ImageIcon("images/Row 2 left.png");
                    if(gameBoard[2]==5) img = new ImageIcon("images/Row 2 left right.png");
                    if(gameBoard[2]==6) img = new ImageIcon("images/Row 2 left center.png");
                    jLabel.setIcon(img);
                    return jLabel;
                }else if(row==3){
                    ImageIcon img = null;
                    JLabel jLabel = new JLabel();
                    if(gameBoard[3]==0) img = new ImageIcon("images/Row 3 empty.png");
                    if(gameBoard[3]==1) img = new ImageIcon("images/Row 3 right.png");
                    if(gameBoard[3]==2) img = new ImageIcon("images/Row 3 center.png");
                    if(gameBoard[3]==3) img = new ImageIcon("images/Row 3 center right.png");
                    if(gameBoard[3]==4) img = new ImageIcon("images/Row 3 left.png");
                    if(gameBoard[3]==5) img = new ImageIcon("images/Row 3 left right.png");
                    if(gameBoard[3]==6) img = new ImageIcon("images/Row 3 left center.png");
                    jLabel.setIcon(img);
                    return jLabel;
                }else if(row==2){
                    ImageIcon img = null;
                    JLabel jLabel = new JLabel();
                    if(gameBoard[4]==0) img = new ImageIcon("images/Row 4 empty.png");
                    if(gameBoard[4]==1) img = new ImageIcon("images/Row 4 right.png");
                    if(gameBoard[4]==2) img = new ImageIcon("images/Row 4 center.png");
                    if(gameBoard[4]==3) img = new ImageIcon("images/Row 4 center right.png");
                    if(gameBoard[4]==4) img = new ImageIcon("images/Row 4 left.png");
                    if(gameBoard[4]==5) img = new ImageIcon("images/Row 4 left right.png");
                    if(gameBoard[4]==6) img = new ImageIcon("images/Row 4 left center.png");
                    jLabel.setIcon(img);
                    return jLabel;
                }else if(row==1){
                    ImageIcon img = null;
                    JLabel jLabel = new JLabel();
                    if(gameBoard[5]==0) img = new ImageIcon("images/Row 5 empty.png");
                    if(gameBoard[5]==1) img = new ImageIcon("images/Row 5 right.png");
                    if(gameBoard[5]==2) img = new ImageIcon("images/Row 5 center.png");
                    if(gameBoard[5]==3) img = new ImageIcon("images/Row 5 center right.png");
                    if(gameBoard[5]==4) img = new ImageIcon("images/Row 5 left.png");
                    if(gameBoard[5]==5) img = new ImageIcon("images/Row 5 left right.png");
                    if(gameBoard[5]==6) img = new ImageIcon("images/Row 5 left center.png");
                    jLabel.setIcon(img);
                    return jLabel;
                }else if(row==0){
                    ImageIcon img = null;
                    JLabel jLabel = new JLabel();
                    if(gameBoard[6]==0) img = new ImageIcon("images/Row 6 empty.png");
                    if(gameBoard[6]==1) img = new ImageIcon("images/Row 6 right.png");
                    if(gameBoard[6]==2) img = new ImageIcon("images/Row 6 center.png");
                    if(gameBoard[6]==3) img = new ImageIcon("images/Row 6 center right.png");
                    if(gameBoard[6]==4) img = new ImageIcon("images/Row 6 left.png");
                    if(gameBoard[6]==5) img = new ImageIcon("images/Row 6 left right.png");
                    if(gameBoard[6]==6) img = new ImageIcon("images/Row 6 left center.png");
                    jLabel.setIcon(img);
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
            int roadWidth = 406;
            int roadHeight = panelHeight;

            g.setColor(Color.GREEN);
           // g.fillRect(0, 0, panelWidth, panelHeight);

            g.setColor(Color.RED);
          //  g.fillRect(150, 0, 20, panelHeight);
           // g.fillRect(panelWidth - 120, 0, 20, panelHeight);

            scorePanel.setBounds(0,0, 145, 70);
            roadTable.setBounds(170, 0, roadWidth, roadHeight);
        }
    }
    class RoadTable extends JTable{
        public RoadTable(int numRows, int numColumns) {
            super(numRows, numColumns);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }
}