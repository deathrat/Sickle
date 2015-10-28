package com.urcraft.wurm.sickle.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ModLoader
{
    private static String MODS_FOLDER = "/mods";
    private ModClassLoader _classLoader;

    public ModLoader()
    {
        _classLoader = new ModClassLoader(new URL[0], getClass().getClassLoader());
    }

    private void addFile(File file)
    {
        try
        {
            _classLoader.addURL(file.toURI().toURL());
            addMod(file);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    private void addMod(File file)
    {
        try
        {
            JarFile jar = new JarFile(file);

            for(Enumeration list = jar.entries(); list.hasMoreElements();)
            {
                JarEntry entry = (JarEntry) list.nextElement();
                if(entry.isDirectory() || !entry.getName().endsWith(".class"))
                    continue;


                Class c = Class.forName(entry.getName().replace('/', '.').substring(0, entry.getName().length()-6), true, _classLoader);
                if(Mod.class.isAssignableFrom(c))
                {
                    Constructor con = c.getConstructor(JarFile.class);
                    Mod mod = (Mod) con.newInstance(jar);
//                    System.out.println("Loaded mod: " + mod.getMeta().getModName());
                }
            }

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }

    public void addMods()
    {
        System.out.println("[Sickle] Loading mods...");
        File f = new File(System.getProperty("user.dir") + MODS_FOLDER);

        if(!f.exists() || !f.isDirectory())
            return;

        for(File file : f.listFiles())
        {
            if(file.isFile() && (file.getName().endsWith(".jar") || file.getName().endsWith(".zip")))
            {
                addFile(file);
            }
        }
    }
}
