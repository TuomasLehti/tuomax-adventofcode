package fi.tuomax.adventofcode.year2022.day11;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 11, part 2:
 * Monkey in the Middle.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/11">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class MonkeyInTheMiddle_Part2
extends MonkeyInTheMiddle_Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 11, 2,
            "Monkey in the Middle", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new MonkeyInTheMiddle_Parser(input);
    }

    @Override
    protected WorryReliever manufactureWorryReliever(List<Monkey> barrel) 
    {
        return new WorryReliever_Part2(barrel);
    }

}
