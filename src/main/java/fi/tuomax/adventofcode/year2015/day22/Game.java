package fi.tuomax.adventofcode.year2015.day22;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;
import fi.tuomax.adventofcode.year2015.day22.spells.Drain;
import fi.tuomax.adventofcode.year2015.day22.spells.MagicMissile;
import fi.tuomax.adventofcode.year2015.day22.spells.Poison;
import fi.tuomax.adventofcode.year2015.day22.spells.Recharge;
import fi.tuomax.adventofcode.year2015.day22.spells.Shield;

public class Game 
{

    private Logger logger = LoggerFactory.getLogger(getClass());

//    private Hero player;

//    private Boss opponent;

    private Integer part;

    public Game(Integer part)
    {
        this.part = part;

        GameState.reset();

        GameState.spells.put("magicmissile", new MagicMissile());
        GameState.spells.put("drain", new Drain());
        GameState.spells.put("shield", new Shield());
        GameState.spells.put("poison", new Poison());
        GameState.spells.put("recharge", new Recharge());

        GameState.player = new Hero(50, 500, (Shield) GameState.spells.get("shield"));
        GameState.opponent = new Boss(71, 10);
    }

    private void turnSpells()
    {
        for (String name : GameState.spells.keySet())
            GameState.spells.get(name).turn(GameState.player, GameState.opponent);
    }

    public static Integer level = 0;

    public static Integer minMana = Integer.MAX_VALUE;

    public void turn()
    {

        Game.level++;
//        System.out.println(level);

        if (GameState.player.isDead() || GameState.opponent.isDead()) {
            gameOver();
            Game.level--;
            return;
        }

        String gameState = GameState.saveState();
        if (GameState.visited.contains(gameState)) {
//            System.out.println("already visited");
            Game.level--;
            return;
        } else {
            GameState.visited.add(gameState);
        }
//        System.out.println(gameState);

        if (part.equals(2)) {
            GameState.player.heal(-1);
            if (GameState.player.getHitPoints() == 0) {
        //            System.out.println("Player loses due to extra rule.");
                Game.level--;
                return;
            }
        }
    
        if (GameState.player.getManaSpent() >= Game.minMana) {
            Game.level--;
            return;
        }

        Boolean spelt = false;

//        String[] casts = new String[]{"recharge","shield","drain","poison","magicmissile"};

        for (String playerSpells : GameState.spells.keySet()) {
//        for (String playerSpells : casts) {
            gameState = GameState.saveState();
//            System.out.println("---"+level+"---");

            if (!GameState.spells.get(playerSpells).isCastable() || GameState.spells.get(playerSpells).getPrice() > GameState.player.getMana())
                continue;
        
//            System.out.println(Game.level+" Player's turn.");
//            System.out.println(Game.level+" "+GameState.saveState());
            turnSpells();
            /* player casts a spell */
//            System.out.println(Game.level+" Player spells " + playerSpells);
            GameState.spells.get(playerSpells).cast(GameState.player, GameState.opponent);
            GameState.player.spendMana(GameState.spells.get(playerSpells).getPrice());
            spelt = true;

//            System.out.println(Game.level+" Opponent's turn.");
//            System.out.println(Game.level+" "+GameState.saveState());
            turnSpells();
//            System.out.println(Game.level+" Opponent hits.");
            GameState.player.getsHit(GameState.opponent.getDamage());

            turn();
            GameState.restoreState(gameState);
        }

//        if (!spelt) 
//            System.out.println("Nothing to spell.");

        Game.level--;

    }

    public void gameOver()
    {
        if (GameState.opponent.getHitPoints() <= 0) {
            logger.debug(Game.level + " Player wins! Mana spent: " + GameState.player.getManaSpent());
            minMana = Math.min(minMana, GameState.player.getManaSpent());
        } else {
//            System.out.println(Game.level + "Player loses!");
        }
    }
    
//1824 too low

}
