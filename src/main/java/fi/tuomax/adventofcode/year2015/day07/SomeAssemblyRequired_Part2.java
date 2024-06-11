package fi.tuomax.adventofcode.year2015.day07;

import java.util.HashMap;
import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 7, part 2: 
 * Some Assembly Required.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/7">
 *      Puzzle on the Advent of Code website.</a>
 */
public class SomeAssemblyRequired_Part2
extends Solver
{

    public SomeAssemblyRequired_Part2()
    {
        super();
    }

    /**
     * Part 2 runs the network of gates twice and resets it in between.
     */
    @Override
    protected void solve() 
    {
        HashMap<String, Gate> gates = ((SomeAssemblyRequired_Parser) parser).getGates();
        Integer answer = gates.get("a").getOutputSignal(gates);

        for (String gateName : gates.keySet())
            gates.get(gateName).reset();
        Gate hardwire = new GateAssign(String.format("%d -> b", answer));
        gates.put("b", hardwire);
        setAnswer(gates.get("a").getOutputSignal(gates));
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 
            7, 
            2, 
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
