package com.github.nodeserverapi.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class FileUtil {

    public static ArrayList<Class> getClassesInJar(File jar) throws IOException, ClassNotFoundException {
        ArrayList<Class> classes = new ArrayList<>();
        try (JarFile jarFile = new JarFile(jar)) {
            Enumeration<JarEntry> e = jarFile.entries();
            URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("jar:" + jar.toURI().toURL() + "!/")});
            while (e.hasMoreElements()) {
                JarEntry entry = e.nextElement();
                if (entry.getName().endsWith(".class")) {
                    String className = entry.getName().replace("/", ".").replace(".class", "");
                    Class clazz = classLoader.loadClass(className);
                    classes.add(clazz);
                }
            }
        }
        return classes;
    }

    public static File[] getPluginsInFolder(File folder) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getAbsolutePath().endsWith(".jar");
            }
        };
        return folder.listFiles(fileFilter);
    }

}

