package ind.milo.demo.gof.listener;

import java.util.ArrayList;
import java.util.List;

public class EventSource {
    private List<EventListener> listeners = new ArrayList<>();

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    public void triggerEvent(Event event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}
