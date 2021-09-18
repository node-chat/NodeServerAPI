package com.github.nodeserverapi.util;

import org.java_websocket.WebSocket;

public class User {

    private final String name;
    private final WebSocket webSocket;

    public User(String name, WebSocket webSocket) {
        this.name = name;
        this.webSocket = webSocket;
    }

    public String getName() {
        return name;
    }

    public WebSocket getWebSocket() {
        return webSocket;
    }
}
