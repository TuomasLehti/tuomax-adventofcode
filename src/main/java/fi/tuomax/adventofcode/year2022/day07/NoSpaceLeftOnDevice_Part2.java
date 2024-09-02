package fi.tuomax.adventofcode.year2022.day07;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 7, part 2:
 * No Space Left On Device.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/7">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class NoSpaceLeftOnDevice_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 7, 2,
            "No Space Left On Device", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new NoSpaceLeftOnDevice_Parser(input);
    }

    Long mustBeFreed = 0L;

    Long smallest = Long.MAX_VALUE;

    @Override
    protected void solve()
    {
        Directory tree =
                ((NoSpaceLeftOnDevice_Parser) parser).getDirectoryTree();
        Long currentlyUnused = 
                getParamInt("total_disk_space") - tree.size();
        mustBeFreed = 
                getParamInt("unused_space_needed") - currentlyUnused;
        findSmallest(tree);
        setAnswer(smallest);
    }

    private void findSmallest(Directory tree)
    {
        if (tree.size() >= mustBeFreed)
            smallest = Math.min(smallest, tree.size());
        for (String dirName : tree.getDirectories().keySet())
            findSmallest(tree.getDirectories().get(dirName));
    }

}
