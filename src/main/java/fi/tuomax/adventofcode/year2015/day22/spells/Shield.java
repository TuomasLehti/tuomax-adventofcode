package fi.tuomax.adventofcode.year2015.day22.spells;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;

public class Shield 
extends Spell
{

    public Shield()
    {
        setPrice(113);
        setEffectLength(6);
    }

    @Override
    public void effect(Hero player, Boss opponent) {}
    
}
