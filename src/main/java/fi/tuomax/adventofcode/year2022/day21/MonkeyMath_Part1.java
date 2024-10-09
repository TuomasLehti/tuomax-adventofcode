package fi.tuomax.adventofcode.year2022.day21;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 21, part 1:
 * Monkey Math.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/21">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class MonkeyMath_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 21, 1,
            "Monkey Math", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new MonkeyMath_Parser(input);
    }

    @Override
    protected void solve()
    {
        setAnswer(Monkey.barrel.get("root").yell());
    }

}
