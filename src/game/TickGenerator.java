package game;

import static game.Board.isWorking;

public class TickGenerator extends Thread{
    int interval = 1000;
    int count = 0;
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                while(isWorking){
                    System.out.println("INTERVAL: " + interval);
                    TickEvent tickEvent = new TickEvent(this);
                    Thread.sleep(interval);
                    count++;
                    if(count%5 == 0 && interval != 100){
                        interval-=50;
                    }
                }
            }
        } catch (InterruptedException e) {

        }
    }
}
