package com.github.nodechatapi.event.impl;

import com.github.nodechatapi.event.Event;
import org.java_websocket.WebSocket;

public class UserMessageEvent extends Event {

    private final String message;
    private final WebSocket socket;

    public UserMessageEvent(WebSocket socket, String message) {
        this.message = message;
        this.socket = socket;
    }

    public WebSocket getSocket() {
        return socket;
    }

    public String getMessage() {
        return message;
    }

}
