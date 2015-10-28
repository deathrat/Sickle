package com.urcraft.wurm.sickle.common;

import java.net.URL;
import java.net.URLClassLoader;

public class ModClassLoader extends URLClassLoader
{

    public ModClassLoader(URL[] urls, ClassLoader parent)
    {
        super(urls, parent);
    }

    @Override
    protected void addURL(URL url)
    {
        super.addURL(url);
    }


}
