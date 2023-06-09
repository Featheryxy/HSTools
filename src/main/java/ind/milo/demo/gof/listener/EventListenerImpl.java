package ind.milo.demo.gof.listener;

public class EventListenerImpl implements EventListener {
    @Override
    public void onEvent(Event event) {
        System.out.println("Dave Recived event: " + event.getData());
    }
}
