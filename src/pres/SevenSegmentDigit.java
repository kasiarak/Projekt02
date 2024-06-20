package pres;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class SevenSegmentDigit extends JPanel implements DigitListener{
    public int value;
    List<DigitListener> listeners = new ArrayList<>();
    public SevenSegmentDigit(){
        this.value = -1;
        this.setPreferredSize(new Dimension(42,60));
        this.setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
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
    public void handleEvent(EventObject event) {
        if (event instanceof StartEvent) {
            this.value = 0;
            repaint();
            notifyListeners(event);
        } else if (event instanceof PlusOneEvent) {
            this.value++;
            if (this.value > 9) {
                this.value = 0;
                notifyListeners(new PlusOneEvent(this));
            }
            repaint();
        } else if (event instanceof ResetEvent) {
            this.value = -1;
            repaint();
            notifyListeners(event);
        }
    }
    public void addDigitListener(DigitListener listener) {
        listeners.add(listener);
    }

    void notifyListeners(EventObject event) {
        for (DigitListener listener : listeners) {
            listener.handleDigitEvent(event);
        }
    }

    @Override
    public void handleDigitEvent(EventObject event) {
        handleEvent(event);
    }
}

