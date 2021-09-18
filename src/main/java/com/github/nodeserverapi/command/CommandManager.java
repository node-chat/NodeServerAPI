package com.github.nodeserverapi.command;

import com.github.nodeserverapi.command.impl.PingCommand;
import com.github.nodeserverapi.event.EventManager;
import com.github.nodeserverapi.event.EventTarget;
import com.github.nodeserverapi.event.Listener;
import com.github.nodeserverapi.event.impl.UserMessageEvent;

import java.util.ArrayList;

public class CommandManager implements Listener {

    private static Boolean registered = false;

    static {
        if (!registered) {
            EventManager.register(new CommandManager());
            CommandManager.register(new PingCommand());
            registered = true;
        }
    }

    private static ArrayList<Command> commands = new ArrayList<>();

    public static void register(Command command) {
        commands.add(command);
    }

    public static void unregister(Command command) {
        commands.remove(command);
    }

    @EventTarget
    public void onMessage(UserMessageEvent event) {
        if (event.getContent().startsWith("/")) {
            String content = event.getContent().replace("/", "");
            String args[] = content.split(" ");
            for (Command command : commands) {
                if (command.getName().equalsIgnoreCase(args[0])) {
                    command.onInvoked(event.getUser(), args);
                }
            }
        }
    }

}
