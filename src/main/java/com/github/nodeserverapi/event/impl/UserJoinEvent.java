package com.github.nodeserverapi.event.impl;

import com.github.nodeserverapi.event.Event;
import com.github.nodeserverapi.util.User;
import org.java_websocket.WebSocket;

public class UserJoinEvent extends Event {

    private final User user;

    public UserJoinEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
