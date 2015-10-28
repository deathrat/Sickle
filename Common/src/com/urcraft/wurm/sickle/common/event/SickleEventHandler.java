package com.urcraft.wurm.sickle.common.event;

import com.google.common.eventbus.EventBus;

public class SickleEventHandler
{
    private static SickleEventHandler _instance;
    public EventBus EVENT_BUS;

    public SickleEventHandler()
    {
        EVENT_BUS = new EventBus();
    }

    public static SickleEventHandler getInstance()
    {
        if(_instance == null)
            _instance = new SickleEventHandler();
        return _instance;
    }
}
