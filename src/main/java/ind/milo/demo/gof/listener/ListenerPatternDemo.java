package ind.milo.demo.gof.listener;

public class ListenerPatternDemo {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        EventListener listener = new EventListenerImpl();
        EventListener listener2 = new EventListenerImpl2();

        eventSource.registerListener(listener);
        eventSource.registerListener(listener2);

        Event event = new Event("Hello World");
        eventSource.triggerEvent(event);


    }
}
