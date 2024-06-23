package fi.tuomax.adventofcode.year2015.day22;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;
import fi.tuomax.adventofcode.year2015.day22.spells.Drain;
import fi.tuomax.adventofcode.year2015.day22.spells.MagicMissile;
import fi.tuomax.adventofcode.year2015.day22.spells.Poison;
import fi.tuomax.adventofcode.year2015.day22.spells.Recharge;
import fi.tuomax.adventofcode.year2015.day22.spells.Shield;
import fi.tuomax.adventofcode.year2015.day22.spells.Spell;

public class TestExamples 
{

    @Test
    public void testFirstExample()
    {
        Hero player = new Hero(10, 250, new Shield());
        Boss opponent = new Boss(14, 8);

        // -- player turn --
        Poison poison = new Poison();
        poison.cast(player, opponent);
        player.spendMana(poison.getPrice());

        // -- boss turn --
        assertEquals(10, (int) player.getHitPoints());
        assertEquals(77, (int) player.getMana());
        assertEquals(13, (int) opponent.getHitPoints());
        poison.turn(player, opponent);
        player.getsHit(opponent.getDamage());

        // -- player turn --
        assertEquals(2, (int) player.getHitPoints());
        assertEquals(77, (int) player.getMana());
        assertEquals(10, (int) opponent.getHitPoints());
        poison.turn(player, opponent);
        MagicMissile magicMissile = new MagicMissile();
        magicMissile.cast(player, opponent);
        player.spendMana(magicMissile.getPrice());
        magicMissile.turn(player, opponent);

        // -- boss turn --
        assertEquals(2, (int) player.getHitPoints());
        assertEquals(24, (int) player.getMana());
        assertEquals(3, (int) opponent.getHitPoints());
        poison.turn(player, opponent);
        magicMissile.turn(player, opponent);

        // -- game over --
        assertTrue(opponent.isDead());
    }

    @Test
    public void testSecondExample()
    {
        Shield shield = new Shield();
        MagicMissile magicMissile = new MagicMissile();
        Drain drain = new Drain();
        Poison poison = new Poison();
        Recharge recharge = new Recharge();

        Set<Spell> spells = new HashSet<>(Arrays.asList(new Spell[]{
            shield, magicMissile, drain, poison, recharge
        }));

        Hero player = new Hero(10, 250, shield);
        Boss opponent = new Boss(14, 8);

        /* Player turn */
        assertEquals(10, (int) player.getHitPoints());
        assertEquals(250, (int) player.getMana());
        assertEquals(14, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        recharge.cast(player, opponent);
        player.spendMana(recharge.getPrice());

        /* Boss turn */
        assertEquals(10, (int) player.getHitPoints());
        assertEquals(21, (int) player.getMana());
        assertEquals(14, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        player.getsHit(opponent.getDamage());

        /* Player turn */
        assertEquals(2, (int) player.getHitPoints());
        assertEquals(122, (int) player.getMana());
        assertEquals(14, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        shield.cast(player, opponent);
        player.spendMana(shield.getPrice());

        /* Boss turn */
        assertEquals(2, (int) player.getHitPoints());
        assertEquals(110, (int) player.getMana());
        assertEquals(14, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        player.getsHit(opponent.getDamage());

        /* Player turn */
        assertEquals(1, (int) player.getHitPoints());
        assertEquals(211, (int) player.getMana());
        assertEquals(14, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        drain.cast(player, opponent);
        player.spendMana(drain.getPrice());

        /* Boss turn */
        assertEquals(3, (int) player.getHitPoints());
        assertEquals(239, (int) player.getMana());
        assertEquals(12, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        player.getsHit(opponent.getDamage());

        /* Player turn */
        assertEquals(2, (int) player.getHitPoints());
        assertEquals(340, (int) player.getMana());
        assertEquals(12, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        poison.cast(player, opponent);
        player.spendMana(poison.getPrice());

        /* Boss turn */
        assertEquals(2, (int) player.getHitPoints());
        assertEquals(167, (int) player.getMana());
        assertEquals(12, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        player.getsHit(opponent.getDamage());

        /* Player turn */
        assertEquals(1, (int) player.getHitPoints());
        assertEquals(167, (int) player.getMana());
        assertEquals(9, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);
        magicMissile.cast(player, opponent);
        player.spendMana(magicMissile.getPrice());

        /* Boss turn */
        assertEquals(1, (int) player.getHitPoints());
        assertEquals(114, (int) player.getMana());
        assertEquals(2, (int) opponent.getHitPoints());
        for (Spell spell : spells) spell.turn(player, opponent);

        assertTrue(opponent.isDead());
    }
    
}
