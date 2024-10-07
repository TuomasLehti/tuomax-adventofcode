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
        return new GrovePositioningSystem_Parser_Part1(input);
    }

    @Override
    protected void solve()
    {
        GpsMixer nums = ((GrovePositioningSystem_Parser) parser).getNums();

        int rounds = getParamInt("rounds");
        for (int r = 0; r < rounds; r++)
            for (int origIdx = 0; origIdx < nums.size(); origIdx++) 
                nums.moveByNum(origIdx);
            

        int zero = nums.getMixedZeroIdx();
        setAnswer(
            nums.getMixed(zero + 1000).num +
            nums.getMixed(zero + 2000).num +
            nums.getMixed(zero + 3000).num
        );
    }

}
