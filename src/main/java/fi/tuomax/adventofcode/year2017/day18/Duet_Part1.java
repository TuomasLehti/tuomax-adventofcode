package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.cpu.Cpu_Parser;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 18, part 1:
 * Duet.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/18">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class Duet_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 18, 1,
            "Duet", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new Cpu_Parser(input, new Duet_InsturctionFactory());
    }

    @Override
    protected void solve()
    {
        ((Cpu_Parser) parser).getCpu().run();
        setAnswer(0);
    }

}
