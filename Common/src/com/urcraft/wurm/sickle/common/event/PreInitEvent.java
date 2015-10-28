package com.urcraft.wurm.sickle.common.event;

public class PreInitEvent
{
    private long _timeCreated;

    public PreInitEvent()
    {
        _timeCreated = System.currentTimeMillis();
    }

    public Long getTimeCreated()
    {
        return _timeCreated;
    }
}
