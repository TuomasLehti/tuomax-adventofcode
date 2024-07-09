package fi.tuomax.adventofcode.year2016.day10;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2016, day 10, part 1: 
 * Explosives in Cyberspace
 * @see 
 *      <a href="https://adventofcode.com/2016/day/10">
 *      Puzzle on the Advent of Code website.</a>
 */public class BalanceBots_Part2
extends BalanceBots_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 10, 2,
            "BalanceBots", ""
        );
    }

    @Override
    protected void solve() 
    {
        super.solve();
        setAnswer(
            bbParser.getBot(900).getFirstChip() *
            bbParser.getBot(901).getFirstChip() *
            bbParser.getBot(902).getFirstChip());
    }
    
}
