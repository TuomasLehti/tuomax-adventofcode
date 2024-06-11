package fi.tuomax.adventofcode.year2015.day07;

import java.util.HashMap;
import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 7, part 1: 
 * Some Assembly Required.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/7">
 *      Puzzle on the Advent of Code website.</a>
 */
public class SomeAssemblyRequired_Part1 
extends Solver
{

    public SomeAssemblyRequired_Part1() 
    {
        super();
    }

    /**
     * Part 1 is solved recursively. Take the output signal of the final gate,
     * which should calculate the output signals of its inputs, and so on.
     */
    @Override
    protected void solve() 
    {
        HashMap<String, Gate> gates = 
            ((SomeAssemblyRequired_Parser) parser).getGates();
        setAnswer(gates.get("a").getOutputSignal(gates));
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 
            7, 
            1, 
            "Some Assembly Required", 
            ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new SomeAssemblyRequired_Parser(input);
    }

    

}
