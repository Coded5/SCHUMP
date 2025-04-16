package com.game.event;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class EventManager {

    private static EventManager eventManager;
    private HashMap<EventId, GameEvent> events = new HashMap<>();

    public EventManager() {
        events.put(EventId.ON_PLAYER_KILL, new GameEvent(EventId.ON_PLAYER_KILL));
        events.put(EventId.ON_PLAYER_HIT , new GameEvent(EventId.ON_PLAYER_HIT));
        events.put(EventId.ON_GAME_OVER , new GameEvent(EventId.ON_GAME_OVER));
    }
//
//    public void dispose() {
//        for (GameEvent gameEvent : events.values()) {
//            gameEvent.clearSubscriber();
//        }
//    }

    public static EventManager getInstance() {
        if (eventManager == null)
            eventManager = new EventManager();

        return eventManager;
    }

    public static void dispose() {
        eventManager = null;
    }

    public void subscribe(EventId eventId, EventObserver observer) {
        events.get(eventId).addSubscriber(observer);
    }

    public void unsubscribe(EventId eventId, EventObserver observer) {
        events.get(eventId).removeSubscriber(observer);
    }

    public void invoke(EventId eventId) {
        System.out.println(eventId + " invoked");
        events.get(eventId).invoke();
    }

}
