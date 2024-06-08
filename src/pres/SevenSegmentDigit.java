package pres;

import javax.swing.*;
import java.awt.*;

public class SevenSegmentDigit extends JPanel {
    int value;
    public SevenSegmentDigit(){
        this.setPreferredSize(new Dimension(42,60));
        value = 0;
        setBackground(Color.BLACK);
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
        g.setColor(Color.RED);
        if(value == 0){
            g.fillRect(12,3,20,3);
            g.fillRect(6,8,3,20);
            g.fillRect(35,8,3,20);
            g.fillRect(35,33,3,20);
            g.fillRect(6,33,3,20);
            g.fillRect(12,55,20,3);
        }else if(value == 1){
            g.fillRect(35,8,3,20);
            g.fillRect(35,33,3,20);
        }else if(value == 2){
            g.fillRect(12,3,20,3);
            g.fillRect(35,8,3,20);
            g.fillRect(12,30,20,3);
            g.fillRect(6,33,3,20);
            g.fillRect(12,55,20,3);
        }else if(value == 3){
            g.fillRect(12,3,20,3);
            g.fillRect(35,8,3,20);
            g.fillRect(12,30,20,3);
            g.fillRect(35,33,3,20);
            g.fillRect(12,55,20,3);
        }else if(value == 4){
            g.fillRect(6,8,3,20);
            g.fillRect(35,8,3,20);
            g.fillRect(12,30,20,3);
            g.fillRect(35,33,3,20);
        }else if(value == 5){
            g.fillRect(12,3,20,3);
            g.fillRect(6,8,3,20);
            g.fillRect(12,30,20,3);
            g.fillRect(35,33,3,20);
            g.fillRect(12,55,20,3);
        }else if(value == 6){
            g.fillRect(12,3,20,3);
            g.fillRect(6,8,3,20);
            g.fillRect(12,30,20,3);
            g.fillRect(35,33,3,20);
            g.fillRect(6,33,3,20);
            g.fillRect(12,55,20,3);
        }else if(value == 7){
            g.fillRect(12,3,20,3);
            g.fillRect(35,8,3,20);
            g.fillRect(35,33,3,20);
        }else if(value == 8){
            g.fillRect(12,3,20,3);
            g.fillRect(6,8,3,20);
            g.fillRect(35,8,3,20);
            g.fillRect(12,30,20,3);
            g.fillRect(35,33,3,20);
            g.fillRect(6,33,3,20);
            g.fillRect(12,55,20,3);
        }else if(value == 9){
            g.fillRect(12,3,20,3);
            g.fillRect(6,8,3,20);
            g.fillRect(35,8,3,20);
            g.fillRect(12,30,20,3);
            g.fillRect(35,33,3,20);
            g.fillRect(12,55,20,3);
        }
    }
}
