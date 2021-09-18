package com.github.nodeserverapi.event.impl;

import com.github.nodeserverapi.event.Event;
import com.github.nodeserverapi.util.DisconnectCause;
import com.github.nodeserverapi.util.User;
import org.java_websocket.WebSocket;

public class ConnCloseEvent extends Event {

    private final WebSocket socket;
    private final DisconnectCause disconncause;
    private User user = null;

    public ConnCloseEvent(WebSocket socket, DisconnectCause disconncause) {
        this.socket = socket;
        this.disconncause = disconncause;
    }

    public ConnCloseEvent(WebSocket socket, DisconnectCause disconncause, User user) {
        this.socket = socket;
        this.disconncause = disconncause;
        this.user = user;
    }

    public WebSocket getSocket() {
        return socket;
    }

    public DisconnectCause getDisconnectCause() {
        return disconncause;
    }

    public User getUser() {
        return user;
    }
}
