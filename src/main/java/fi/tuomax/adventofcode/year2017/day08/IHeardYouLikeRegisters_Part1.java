package fi.tuomax.adventofcode.year2017.day08;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 8, part 1:
 * I Heard You Like Registers.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/8">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class IHeardYouLikeRegisters_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 8, 1,
            "I Heard You Like Registers", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new IHeardYouLikeRegisters_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Instruction> instructions = ((IHeardYouLikeRegisters_Parser) parser).getInstructions();
        RegisterArray registers = new RegisterArray();
        for (Instruction instruction : instructions) {
            instruction.execute(registers);
        }
        setAnswer(registers.getHighestValue());
    }

}
