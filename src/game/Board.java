package game;

import pres.MainPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pres.StartEvent;

public class Board implements KeyListener {
    private final MainPanel mainPanel;
    KeyListener keyListener;
    static boolean isWorking = false;
    boolean scoreIsShowing = false;
    TickGenerator tickGenerator;

    public Board(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 's') {
            if(!scoreIsShowing){
                scoreIsShowing = true;
                mainPanel.unity.handleEvent(new StartEvent(mainPanel.unity));
                mainPanel.tens.handleEvent(new StartEvent(mainPanel.tens));
                mainPanel.hundreds.handleEvent(new StartEvent(mainPanel.hundreds));
                tickGenerator = new TickGenerator();
                tickGenerator.start();
            }
            if(!isWorking){
                isWorking = true;
                keyListener = new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyChar()=='a'){
                            if(mainPanel.carPosition != 1){
                                mainPanel.carPosition--;
                                mainPanel.updateView();
                            }
                        }else if(e.getKeyChar()=='d'){
                            if(mainPanel.carPosition != 3){
                                mainPanel.carPosition++;
                                mainPanel.updateView();
                            }
                        }
                    }
                };
                mainPanel.addKeyListener(keyListener);
            }else{
                isWorking = false;
                mainPanel.removeKeyListener(keyListener);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
