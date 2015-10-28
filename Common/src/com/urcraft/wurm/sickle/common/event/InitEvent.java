package com.urcraft.wurm.sickle.common.event;



public class InitEvent
{
    private long _timeCreated;

    public InitEvent()
    {
        _timeCreated = System.currentTimeMillis();
    }

    public Long getTimeCreated()
    {
        return _timeCreated;
    }
}
