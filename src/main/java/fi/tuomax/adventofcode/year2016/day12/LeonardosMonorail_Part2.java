package fi.tuomax.adventofcode.year2016.day12;

import java.util.List;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Cpu_Parser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 12, part 2: 
 * Leonardo's Monorail
 * @see 
 *      <a href="https://adventofcode.com/2016/day/12">
 *      Puzzle on the Advent of Code website.</a>
 */
public class LeonardosMonorail_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 12, 2,
            "Leonardo's Monorail", ""  
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new Cpu_Parser(input, new LeonardosMonorail_InstructionFactory());
    }

    @Override
    protected void solve() 
    {
        Cpu cpu = ((Cpu_Parser) parser).getCpu();
        cpu.setRegister("c", 1);
        cpu.run();
        setAnswer(cpu.getRegister("a"));
    }
    
}
