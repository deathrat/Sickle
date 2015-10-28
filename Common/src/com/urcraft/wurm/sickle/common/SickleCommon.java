package com.urcraft.wurm.sickle.common;

import com.urcraft.wurm.sickle.common.event.SickleEventBus;

import java.util.ArrayList;

public class SickleCommon
{
    public static SickleEventBus EVENTBUS = new SickleEventBus();
    private static ArrayList<Mod> _modList = new ArrayList<>();
    public static String LOG_TAG = "[Sickle] "; //TODO: Create Logging class

    public static void addMod(Mod mod)
    {
        _modList.add(mod);
    }
}
