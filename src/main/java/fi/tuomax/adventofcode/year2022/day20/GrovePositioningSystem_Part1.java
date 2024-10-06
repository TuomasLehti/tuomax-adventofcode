package fi.tuomax.adventofcode.year2022.day20;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 20, part 1:
 * Grove Positioning System.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/20">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class GrovePositioningSystem_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 20, 1,
            "Grove Positioning System", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new GrovePositioningSystem_Parser(input);
    }

    @Override
    protected void solve()
    {
        GpsSequence nums = ((GrovePositioningSystem_Parser) parser).getNums();
        nums.moveAll();
        GpsNumber zero = nums.getNum(0);
        setAnswer(
            nums.getIdx((zero.currIdx + 1000) % nums.nums.size()).num +
            nums.getIdx((zero.currIdx + 2000) % nums.nums.size()).num +
            nums.getIdx((zero.currIdx + 3000) % nums.nums.size()).num
        );
    }

}
