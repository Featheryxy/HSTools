package ind.milo.gof.observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private ArrayList<Observer> observers = new ArrayList();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = (Observer) iterator.next();
            // 将当前对象作为参数，通知观察者，
            observer.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();
}
