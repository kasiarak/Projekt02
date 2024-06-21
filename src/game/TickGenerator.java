package game;

import java.util.ArrayList;
import java.util.List;

public class TickGenerator extends Thread{
    static TickGenerator instance = null;
    int interval = 1000;
    int count = 0;
    List<TickEventListener> listeners = new ArrayList<>();
    public static synchronized TickGenerator getInstance() {
        if (instance == null) {
            instance = new TickGenerator();
        }
        return instance;
    }
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
                notifyTickEvent();
                Thread.sleep(interval);
                count++;
                if(count%5 == 0 && interval != 200){
                    interval-=50;
                }
            }
        } catch (InterruptedException e) {

        }
    }
}
