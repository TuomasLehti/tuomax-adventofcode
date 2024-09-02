package fi.tuomax.adventofcode.year2022.day07;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 7, part 1:
 * No Space Left On Device.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/7">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class NoSpaceLeftOnDevice_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 7, 1,
            "No Space Left On Device", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new NoSpaceLeftOnDevice_Parser(input);
    }

    @Override
    protected void solve()
    {
        Directory tree = ((NoSpaceLeftOnDevice_Parser) parser).getDirectoryTree();
        setAnswer(sum(tree));
    }

    private Long sum(Directory tree)
    {
        Long sum = tree.size() <= getParamInt("upper_limit") ? tree.size() : 0L;
        for (String dirName : tree.getDirectories().keySet())
            sum += sum(tree.getDirectories().get(dirName));
        return sum;
    }

}
