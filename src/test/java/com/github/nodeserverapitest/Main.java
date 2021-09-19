package com.github.nodeserverapitest;

import com.github.nodeserverapi.plugin.PluginLoader;

import java.io.File;

public class Main {

    public static File getPluginFolder() {
        File file = new File(System.getProperty("user.dir"), "plugins");
        if (!file.isDirectory()) {
            return null;
        } else if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static void main(String args[]) throws Exception {
        PluginLoader pluginLoader = new PluginLoader(getPluginFolder());
        pluginLoader.loadPlugin(new File(getPluginFolder(), "plugin.jar"));
    }

}
