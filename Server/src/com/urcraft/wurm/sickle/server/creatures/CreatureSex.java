package com.urcraft.wurm.sickle.server.creatures;

public enum CreatureSex
{
    MALE(0),
    FEMALE(1);

    public byte sex;
    CreatureSex(int i)
    {
        sex = (byte) i;
    }
}
