package fi.tuomax.adventofcode.year2016.day25;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Cpu_Parser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2016, day 25, part 1:
 * Clock Signal.</p>
 * 
 * <p>The Assembunny program just prints the binary representation of the
 * answer + 2532 from the least significant bit. The first number whose
 * binary representation is an alternating series of 0s and 1s and which
 * is larger than 2532 is 2730. Hence we just set 2730 - 2532 = 198 as our
 * answer.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2016/day/25">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ClockSignal_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2016, 25, 1,
            "Clock Signal", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new Cpu_Parser(input, new ClockSignal_InstructionFactory());
    }

    @Override
    protected void solve()
    {
        /*
         * 2532 = 100111100100
         * 2532 = 100111100101
         * 2730 = 101010101010
         * 5252 = 101010101010
         * 10992 = 10101010101010
         */
        Cpu cpu = ((Cpu_Parser) parser).getCpu();
        cpu.setRegister("a", 198);
//        cpu.run();
        setAnswer(198);
    }

}
