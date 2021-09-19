package com.github.nodeserverapi;

import com.github.nodeserverapi.command.Command;
import com.github.nodeserverapi.command.CommandManager;
import com.github.nodeserverapi.plugin.PluginLoader;

import java.io.File;

public class NodeAPI {

    public NodeAPI() {

    }

    public static File getPluginFolder() {
        File file = new File("C:/Users/iyeng_pqutlme/IdeaProjects/NodeChatAPI/plugins");
        if (!file.isDirectory()) {
            return null;
        } else if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static void main(String args[]) throws Exception {
        getPluginFolder();
        PluginLoader pluginLoader = new PluginLoader(getPluginFolder());
        pluginLoader.loadPlugins();
        for (Command command : CommandManager.getCommands()) {
            System.out.println(command.getName());
        }
    }

}
