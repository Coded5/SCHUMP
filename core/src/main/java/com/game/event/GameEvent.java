package com.game.event;

import java.util.ArrayList;

public class GameEvent {

    private EventId eventId;
    private ArrayList<EventObserver> subscriber = new ArrayList<>();

    public GameEvent(EventId eventId) {
        this.eventId = eventId;
    }

    public void invoke() {
        for (EventObserver observer : subscriber) {
            observer.onEvent();
        }
    }

    public void addSubscriber(EventObserver observer) {
        subscriber.add(observer);
    }

    public void removeSubscriber(EventObserver observer) {
        subscriber.remove(observer);
    }

    public void clearSubscriber() {
        this.subscriber.clear();
    }

    public EventId getEventId() {
        return eventId;
    }

}
