package com.github.nodechatapi.event.impl;

import com.github.nodechatapi.event.Event;
import org.java_websocket.WebSocket;

public class UserJoinEvent extends Event {

    private final WebSocket socket;

    public UserJoinEvent(WebSocket socket) {
        this.socket = socket;
    }

    public WebSocket getSocket() {
        return socket;
    }

}
