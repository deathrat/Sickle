package com.urcraft.wurm.sickle.server.creatures;

public enum CreatureType
{
    SENTINEL(0),
    TRADER(1),
    RANDOM_MOVEMENT(2),
    ANIMAL(3),
    INVULNERABLE(4),
    NPC_TRADER(5),
    AGGRESSIVE_HUMAN(6),
    MOVE_LOCAL(7),
    MOVE_GLOBAL(8),
    GRAZER(9),
    HERD(10),
    VILLAGE_GUARD(11),
    SWIMMING(12),
    HUNTER(13),
    LEADABLE(14),
    MILKABLE(15),
    MONSTER(16),
    HUMAN(17),
    REGENERATING(18),
    DRAGON(19),
    UNIQUE(20),
    KINGDOM_GUARD(21),
    GHOST(22),
    SPIRIT_GUARD_FLOATING(23),
    DEFEND_KINGDOM(24),
    AGGRESSIVE_WHITIE(25),
    BARTENDER(26),
    OMNIVORE(27),
    FLEEING_HERBIVORE(28),
    CARNIVORE(29),
    CLIMBER(30),
    DOMINATBLE(32),
    UNDEAD(33),
    CAVE_DWELLER(34),
    FLEEING(35),
    DETECT_INVIS(36),
    IS_SUBMERGED(37),
    IS_FLOATING(38),
    NON_NEWBIE(39),
    IS_BREAK_FENCE(40),
    IS_VEHICLE(41),
    IS_HORSE(42),
    DOMESTIC(43),
    MOVE_RATE_100_AND_CAREFUL(44),
    CAN_OPEN_DOORS(45),
    SET_TOWER_BASHER(46),
    SET_ONLY_ATTACKS_PLAYERS(47),
    DOESNT_ATTACK_VEHICLES(48),
    IS_PREY(49),
    IS_FROM_VALREI(50),
    IS_BEACH_DWELLER(51),
    WOOL_PRODUCER(52),
    SET_WAR_GUARD(53),
    IS_BLACK_OR_WHITE(54);


    public int id;
    CreatureType(int id)
    {
        this.id = id;
    }
}
