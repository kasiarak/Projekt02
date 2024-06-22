package game;

import pres.MainPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pres.PlusOneEvent;
import pres.ResetEvent;
import pres.StartEvent;

public class Board implements KeyListener, TickEventListener {
    private final MainPanel mainPanel;
    KeyListener keyListener;
    TickGenerator tickGenerator;
    int freeRows = 0;

    public Board(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 's' && !TickGenerator.getInstance().isAlive()) {
            mainPanel.unity.handleEvent(new StartEvent(mainPanel.unity));
            tickGenerator = TickGenerator.getInstance();
            tickGenerator.addTickEventListener(this);
            tickGenerator.start();
            keyListener = new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyChar()=='a'){
                        if(mainPanel.gameBoard[0]==2){
                            mainPanel.gameBoard[0]=4;
                            mainPanel.updateView(6);
                        }else if(mainPanel.gameBoard[0]==1){
                            mainPanel.gameBoard[0]=2;
                            mainPanel.updateView(6);
                        }
                    }else if(e.getKeyChar()=='d'){
                        if(mainPanel.gameBoard[0]==2){
                            mainPanel.gameBoard[0]=1;
                            mainPanel.updateView(6);
                        }else if(mainPanel.gameBoard[0]==4){
                            mainPanel.gameBoard[0]=2;
                            mainPanel.updateView(6);
                        }
                    }
                }
            };
            mainPanel.addKeyListener(keyListener);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void handleTickEvent(TickEvent tickEvent) {
        boolean[] arr = new boolean[7];
        if((mainPanel.gameBoard[0] & mainPanel.gameBoard[1]) != 0){
            mainPanel.unity.handleEvent(new ResetEvent(mainPanel.unity));
            tickGenerator.interrupt();
            mainPanel.removeKeyListener(keyListener);
        }else{
            if(mainPanel.gameBoard[1] != 0){
                if(mainPanel.hundreds.value==9){
                    mainPanel.unity.handleEvent(new ResetEvent(mainPanel.unity));
                    mainPanel.removeKeyListener(keyListener);
                    tickGenerator.interrupt();
                }else{
                    mainPanel.unity.handleEvent(new PlusOneEvent(mainPanel.unity));
                }
            }

            if(mainPanel.gameBoard[2] != mainPanel.gameBoard[1]){
                mainPanel.gameBoard[1] = mainPanel.gameBoard[2];
               arr[0] = true;
            }
            if(mainPanel.gameBoard[3] != mainPanel.gameBoard[2]){
                mainPanel.gameBoard[2] = mainPanel.gameBoard[3];
                arr[1] = true;
            }
            if(mainPanel.gameBoard[4] != mainPanel.gameBoard[3]){
                mainPanel.gameBoard[3] = mainPanel.gameBoard[4];
                arr[2] = true;
            }
            if(mainPanel.gameBoard[5] != mainPanel.gameBoard[4]){
                mainPanel.gameBoard[4] = mainPanel.gameBoard[5];
                arr[3] = true;
            }
            if(mainPanel.gameBoard[6] != mainPanel.gameBoard[5]){
                mainPanel.gameBoard[5] = mainPanel.gameBoard[6];
                arr[4] = true;
            }
            if(freeRows==0){
                int row = (int)(1+Math.random()*6);
                mainPanel.gameBoard[6] = row;
                if(mainPanel.unity.value==0) freeRows++;
                if(mainPanel.tens.value==0) freeRows++;
                if(mainPanel.hundreds.value==0) freeRows++;
                if(freeRows==0) freeRows++;
            }else{
                if(mainPanel.gameBoard[6]!=0){
                    mainPanel.gameBoard[6]=0;
                    mainPanel.updateView(0);
                }
                freeRows--;
            }
            mainPanel.update(arr);
        }
    }
}