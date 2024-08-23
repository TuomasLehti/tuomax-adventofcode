package fi.tuomax.adventofcode.year2016.day23;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Cpu_Parser;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.List;

/**
 * <p>Solves Advent of Code 2016, day 23, part 1:
 * Safe Cracking.</p>
 * 
 * <p>Part one finishes in almost no time at all by just simulating the 
 * Assembunny computer.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/23">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SafeCracking_Part1
extends Solver
{

    public SafeCracking_Part1()
    {
        super();
        InstructionFactory.use(new SafeCracking_InstructionFactory());
    }

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 23, 1,
            "Safe Cracking", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new Cpu_Parser(input, new SafeCracking_InstructionFactory());
    }

    @Override
    protected void solve()
    {
        Cpu cpu = ((Cpu_Parser) parser).getCpu();
        cpu.setRegister("a", 7);
        cpu.run();
        setAnswer(cpu.getRegister("a"));
    }

}
