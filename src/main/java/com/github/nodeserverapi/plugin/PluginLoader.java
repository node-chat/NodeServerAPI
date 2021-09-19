package com.github.nodeserverapi.plugin;
import com.github.nodeserverapi.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.jar.JarFile;

public class PluginLoader {

    private final File folder;
    private final ArrayList<JarFile> plugins = new ArrayList<>();

    public PluginLoader(File folder) {
        this.folder = folder;
    }

    public void loadPlugin(File jar) throws Exception {
        ArrayList<Class> classes = FileUtil.getClassesInJar(jar);
        for (Class clazz : classes) {
            if (clazz.isAssignableFrom(NodePlugin.class)) {
                Class<NodePlugin> pluginClass = clazz;
                pluginClass.newInstance().onEnable();
            }
        }
    }

}
