package com.urcraft.wurm.sickle.server.creatures;

public enum CreatureBodyType
{
    HUMAN(0),
    HORSE(1),
    BEAR(2),
    DOG(3),
    ETTIN(4),
    CYCLOPS(5),
    DRAGON(6),
    BIRD(7),
    SPIDER(8),
    SNAKE(9);

    public byte bodyType;
    CreatureBodyType(int bodyType)
    {
        this.bodyType = (byte) bodyType;
    }
}
