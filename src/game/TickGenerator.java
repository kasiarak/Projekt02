package game;

import java.util.ArrayList;
import java.util.List;

import static game.Board.isWorking;

public class TickGenerator extends Thread{
    int interval = 1000;
    int count = 0;
    List<TickEventListener> listeners = new ArrayList<>();
    public void addTickEventListener(TickEventListener listener) {
        listeners.add(listener);
    }
     void notifyTickEvent() {
        TickEvent event = new TickEvent(this);
        for (TickEventListener listener : listeners) {
            listener.handleTickEvent(event);
        }
    }
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                while(isWorking){
                    notifyTickEvent();
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
