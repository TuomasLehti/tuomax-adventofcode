package fi.tuomax.adventofcode.year2015.day22.spells;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;

public class MagicMissile 
extends Spell
{

    public MagicMissile()
    {
        setPrice(53);
    }

    @Override
    public void cast(Hero player, Boss opponent)
    {
        super.cast(player, opponent);
        opponent.getsHit(4);
    }

    @Override
    public void effect(Hero player, Boss opponent) {}
    
}
