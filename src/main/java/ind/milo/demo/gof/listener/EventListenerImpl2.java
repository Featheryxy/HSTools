package ind.milo.demo.gof.listener;

public class EventListenerImpl2 implements EventListener {
    private String name = "Tom";
    @Override
    public void onEvent(Event event) {
        System.out.println("Tom Recived event: " + event.getData());
    }


}
