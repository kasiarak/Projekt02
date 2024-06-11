package game;

import java.util.EventListener;

public interface TickEventListener extends EventListener {
    void handleTickEvent(TickEvent tickEvent);
}
