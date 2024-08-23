package fi.tuomax.adventofcode.year2016.day23;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Cpu_Parser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2016, day 23, part 2:
 * Safe Cracking.</p>
 * 
 * <p>Part 2 takes quite a while to complete by just simulating the Assembunny
 * computer. After analyzing the code I realised that the first part calculates
 * a factorial, and the second part multiplies two constants and adds them to
 * the result of the factorial. This solver calculates the result without any
 * simulation at all.</p>
 * 
 * <p>The Cpu should be refactored to have an optimizer, which turns the 
 * increment/decrement loops into faster code. I'll definitely do that if 
 * there's more Assembunny stuff in the following years. If there's not, I'll
 * keep this in mind as a trick for other similar challenges.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/23">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SafeCracking_Part2
extends Solver
{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 23, 2,
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
        Long factorial = 1L;
        for (int i = 12; i > 0; i--)
            factorial *= i;
        setAnswer(factorial + 81 * 73);
    }

}
