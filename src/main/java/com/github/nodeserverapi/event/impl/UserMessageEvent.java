package com.github.nodeserverapi.event.impl;

import com.github.nodeserverapi.event.Event;
import com.github.nodeserverapi.util.User;
import org.java_websocket.WebSocket;

public class UserMessageEvent extends Event {

    private final String message;
    private final String content;
    private final User user;

    public UserMessageEvent(User user, String message, String content) {
        this.message = message;
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public String getContent() {
        return content;
    }
}
