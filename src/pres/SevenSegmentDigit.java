package pres;

import javax.swing.*;
import java.awt.*;

public class SevenSegmentDigit extends JPanel {
    int value;
    public SevenSegmentDigit(){
        this.setPreferredSize(new Dimension(30,60));
        value = 0;
    }
    void setValue(int value){
        if(value >= 0 && value <= 9){
            this.value = value;
            repaint();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
