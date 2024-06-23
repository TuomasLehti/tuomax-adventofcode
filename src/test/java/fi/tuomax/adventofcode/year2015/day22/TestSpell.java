package fi.tuomax.adventofcode.year2015.day22;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;
import fi.tuomax.adventofcode.year2015.day22.spells.Shield;
import fi.tuomax.adventofcode.year2015.day22.spells.Spell;

public class TestSpell 
{

    @Test
    public void testEffect()
    {
        SimpleSpell spell = new SimpleSpell(2);
        Hero hero = new Hero(0, 0, new Shield());
        Boss boss = new Boss(0, 0);

        /* Player's turn. Player casts spell. */
        spell.turn(hero, boss);
        assertTrue(spell.isCastable());
        spell.cast(hero, boss);

        /* Opponent's turn. */
        /* Spell effects players. */
        /* Spell's counter is now 1. */
        spell.turn(hero, boss);
        assertEquals(1, (int) spell.effectedTurns);

        /* Player's turn. */
        assertFalse(spell.isCastable());
        /* Spell effects players. */
        /* Spell's counter is now 0. */
        /* Spell wears out. */
        spell.turn(hero, boss);
        assertEquals(2, (int) spell.effectedTurns);

        /* Opponent's turn. */
        /* Spell should have no effect. */
        spell.turn(hero, boss);
        assertEquals(2, (int) spell.effectedTurns);

        /* Player's turn. */
        /* Spell is castable. */
        assertTrue(spell.isCastable());
        spell.turn(hero, boss);
    }

    private class SimpleSpell 
    extends Spell
    {
        public Integer effectedTurns = 0;
        public SimpleSpell(Integer effectLength) 
        {
            setEffectLength(effectLength);
        }
        @Override
        public void effect(Hero player, Boss opponent) 
        {
            effectedTurns++;
        }
    }
    
}
