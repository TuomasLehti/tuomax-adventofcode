package fi.tuomax.adventofcode.year2024.day09;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 9, part 1:
 * Disk Fragmenter.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/9">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DiskFragmenter_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 9, 1,
            "Disk Fragmenter", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new DiskFragmenter_Parser(input);
    }

    private DiskMap getDiskMap()
    {
        return ((DiskFragmenter_Parser) parser).getDiskMap();
    }

    @Override
    protected void solve()
    {
        DiskMap dm = getDiskMap();
        dm.fragment();
        setAnswer(dm.checkSum());
    }

}