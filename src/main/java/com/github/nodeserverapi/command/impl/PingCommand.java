package com.github.nodeserverapi.command.impl;

import com.github.nodeserverapi.command.Command;
import com.github.nodeserverapi.util.User;

public class PingCommand implements Command {
    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public void onInvoked(User user, String[] args) {
        user.getWebSocket().send("[SERVER] Pong!");
    }
}
