package com.github.nodeserverapi.command;

import com.github.nodeserverapi.util.User;

public interface Command {

    String getName();

    void onInvoked(User user, String args[]);

}
