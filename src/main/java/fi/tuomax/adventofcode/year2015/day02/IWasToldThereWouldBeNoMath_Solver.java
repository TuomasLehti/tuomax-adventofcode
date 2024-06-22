package fi.tuomax.adventofcode.year2015.day02;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 1: 
 * I Was Told There Would Be No Math.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/2">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class IWasToldThereWouldBeNoMath_Solver 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new IWasToldThereWouldBeNoMath_Parser(input);
    }

    /**
     * Finds the smallest of three integers.
     */
    public Integer minimum(Integer i1, Integer i2, Integer i3) 
    {
        return (Math.min(i1, Math.min(i2, i3)));
    }

    protected abstract Integer calculation(Present present);

    @Override
    protected void solve() {
        Integer result = 0;
        for (Present present : (IWasToldThereWouldBeNoMath_Parser) parser) {
            result += calculation(present);
        }
        setAnswer(result);
    }
    
}
