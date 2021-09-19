package com.github.nodeserverapi.command;

import com.github.nodeserverapi.event.EventManager;
import com.github.nodeserverapi.event.EventTarget;
import com.github.nodeserverapi.event.Listener;
import com.github.nodeserverapi.event.impl.UserMessageEvent;

import java.util.ArrayList;

public class CommandManager implements Listener {

    private static final ArrayList<Command> commands = new ArrayList<>();

    public static ArrayList<Command> getCommands() {
        return commands;
    }

    public static void enable() {
        EventManager.register(new CommandManager());
    }

    public static void register(Command command) {
        commands.add(command);
    }

    public static void unRegister(Command command) {
        commands.remove(command);
    }

    @EventTarget
    public void onMessage(UserMessageEvent event) {
        if (event.getContent().startsWith("/")) {
            event.setCancelled(true);
            String content = event.getContent().replace("/", "");
            String[] args = content.split(" ");
            for (Command command : getCommands()) {
                if (command.getName().equalsIgnoreCase(args[0])) {
                    command.onInvoked(event.getUser(), args);
                }
            }
        }
    }

}
