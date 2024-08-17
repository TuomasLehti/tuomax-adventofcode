package fi.tuomax.adventofcode.year2016.day19;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>The common part of solving both parts of Advent of Code 2016, day 19: 
 * An Elephant Named Joseph.
 * 
 * <p>The game of sharing presents is simulated. There is a mathematical way to
 * solve these puzzles as well, but on modern hardware this approach is fast
 * enough. I'm not in this for the fastest solution (at least not yet).</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2016/day/19">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class AnElephantNamedJoseph 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    @Override
    protected void solve() 
    {
        Integer numOfElves = Integer.valueOf(((StringParser) parser).getString());
        Elf.create(numOfElves);

        Elf turn = Elf.head;
        Elf from = stealFrom(turn);
        while (turn.steal(from)) {
            turn = turn.left;
            from = stealFrom(turn);
        }
        setAnswer(turn.num);
    }

    protected abstract Elf stealFrom(Elf inTurn);
    
}
