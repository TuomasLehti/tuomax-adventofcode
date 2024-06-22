package fi.tuomax.adventofcode.year2015.day21;

import java.util.List;
import java.util.Set;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 21, part 1: 
 * RPG Simulator 20XX.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/21">
 *      Puzzle on the Advent of Code website.</a>
 */
public class RpgSimulator20xx_Part2 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 21, 2, 
            "RPG Simulator 20XX", ""
        );    
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new RPGSimulator20XX_Parser(input);
    }

    @Override
    protected void solve() 
    {
        final Integer PLAYER_HP = 100;
        final Player OPPONENT = ((RPGSimulator20XX_Parser) parser).getOpponent();
        final Shop SHOP = ((RPGSimulator20XX_Parser) parser).getShop();

        Integer highestPrice = Integer.MIN_VALUE;
        for (Set<Weapon> weapons : SHOP) {
            Player player = new Player(PLAYER_HP, weapons);
            if (!player.wins(OPPONENT))
                highestPrice = Math.max(highestPrice, SHOP.price(weapons));
        }
        setAnswer(highestPrice);
    }
    
}
