package com.urcraft.wurm.sickle.server.events;

import com.wurmonline.server.creatures.Creature;

import java.sql.ResultSet;

public class CreatureInitializeEvent
{
    private String _templateName;
    private ResultSet _rs;
    private Creature _statusHolder;

    public CreatureInitializeEvent(String templateName, ResultSet rs, Creature statusHolder)
    {
        _templateName = templateName;
        _rs = rs;
        _statusHolder = statusHolder;
    }

    public Creature getStatusHolder()
    {
        return _statusHolder;
    }
}
