package cz.litvaluk.fit.adp.game.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<Observer> observers = new ArrayList<>();

    public boolean attachObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            return true;
        }
        return false;
    }

    public boolean detachObserver(Observer observer) {
        return observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
