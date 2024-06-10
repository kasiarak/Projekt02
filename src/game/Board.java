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

                tickGenerator = new TickGenerator();
                tickGenerator.start();
            }
            if(!isWorking){
                isWorking = true;
                keyListener = new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyChar()=='a'){
                            if(mainPanel.carPosition != 0){
                                mainPanel.carPosition--;
                                for(int i = 0; i < mainPanel.gameBoard[0].length; i++){
                                    if(i!=mainPanel.carPosition) mainPanel.gameBoard[0][i] = 0;
                                    else mainPanel.gameBoard[0][i] = 1;
                                }
                                mainPanel.updateView();
                            }
                        }else if(e.getKeyChar()=='d'){
                            if(mainPanel.carPosition != 2){
                                mainPanel.carPosition++;
                                for(int i = 0; i < mainPanel.gameBoard[0].length; i++){
                                    if(i!=mainPanel.carPosition) mainPanel.gameBoard[0][i] = 0;
                                    else mainPanel.gameBoard[0][i] = 1;
                                }
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
