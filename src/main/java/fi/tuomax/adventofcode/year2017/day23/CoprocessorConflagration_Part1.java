package fi.tuomax.adventofcode.year2017.day23;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Cpu_Parser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 23, part 1:
 * Coprocessor Conflagration.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/23">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CoprocessorConflagration_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 23, 1,
            "Coprocessor Conflagration", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new Cpu_Parser(
            input, 
            new CoprosessorConflagration_InstructionFactory(), 
            new String[]{"a", "b", "c", "d", "e", "f", "g", "h"});
    }

    @Override
    protected void solve()
    {
        Cpu cpu = ((Cpu_Parser) parser).getCpu();
        cpu.run();
        setAnswer(MultiplyCounter.runCount);
    }




}
