package com.github.nodeserverapi.event.impl;

import com.github.nodeserverapi.event.Event;
import com.github.nodeserverapi.util.DisconnectCause;
import org.java_websocket.WebSocket;

public class ConnCloseEvent extends Event {

    private final WebSocket socket;
    private final DisconnectCause disconncause;
    private String name = null;

    public ConnCloseEvent(WebSocket socket, DisconnectCause disconncause) {
        this.socket = socket;
        this.disconncause = disconncause;
    }

    public ConnCloseEvent(WebSocket socket, DisconnectCause disconncause, String name) {
        this.socket = socket;
        this.disconncause = disconncause;
        this.name = name;
    }

    public WebSocket getSocket() {
        return socket;
    }

    public DisconnectCause getDisconnectCause() {
        return disconncause;
    }

    public String getName() {
        return name;
    }
}
