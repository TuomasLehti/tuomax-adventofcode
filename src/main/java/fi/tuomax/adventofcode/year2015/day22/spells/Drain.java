package fi.tuomax.adventofcode.year2015.day22.spells;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;

public class Drain 
extends Spell
{

    public Drain()
    {
        setPrice(73);
    }

    @Override
    public void cast(Hero player, Boss opponent)
    {
        super.cast(player, opponent);
        opponent.getsHit(2);
        player.heal(2);
    }

    @Override
    public void effect(Hero player, Boss opponent) {}
    
}
