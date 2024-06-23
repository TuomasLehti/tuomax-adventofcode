package fi.tuomax.adventofcode.year2015.day22.spells;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;

public class Recharge 
extends Spell
{

    public Recharge()
    {
        setPrice(229);
        setEffectLength(5);
    }

    public void cast(Hero player, Boss opponent)
    {
        super.cast(player, opponent);
    }

    @Override
    public void effect(Hero player, Boss opponent) {
        player.manaRefill(101);
    }

}
