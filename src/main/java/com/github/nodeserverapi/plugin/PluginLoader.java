package com.github.nodeserverapi.plugin;
import com.github.nodeserverapi.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.jar.JarFile;

public class PluginLoader {

    private final File folder;

    public PluginLoader(File folder) {
        this.folder = folder;
    }

    public void loadPlugin(File jar) throws Exception {
        ArrayList<Class> classes = FileUtil.getClassesInJar(jar);
        Iterator iterator = classes.iterator();
        while (iterator.hasNext()) {
            try {
                Class<NodePlugin> pluginClass = (Class<NodePlugin>) iterator.next();
                pluginClass.newInstance().onEnable();
                System.out.println("Enabled plugin " + jar.getName());
                return;
            } catch (ClassCastException e) {
                if (!iterator.hasNext()) {
                    System.out.println("Failed to load plugin " + jar.getName());
                }
            }
        }
        /*for (Class clazz : classes) {
            System.out.println(clazz);
            try {
                Class<NodePlugin> pluginClass = clazz;
                pluginClass.newInstance().onEnable();
                System.out.println("Enabled plugin " + jar.getName());
                return;
            } catch (ClassCastException e) {
                System.out.println("Failed to load plugin " + jar.getName());
            }
        }
        System.out.println("Failed to load plugin!");*/
    }

    public void loadPlugins() throws Exception {
        for (File jar : FileUtil.getPluginsInFolder(folder)) {
            loadPlugin(jar);
        }
    }

}
