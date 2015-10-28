package com.urcraft.wurm.sickle.common.event;

public class PostInitEvent
{
    private long _timeCreated;

    public PostInitEvent()
    {
        _timeCreated = System.currentTimeMillis();
    }

    public Long getTimeCreated()
    {
        return _timeCreated;
    }
}
