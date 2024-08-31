package fi.tuomax.adventofcode.year2022.day03;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 3, part 1:
 * Rucksack Reorganization.</p>
 * 
 * <p>Solving logic is in the parent class and is the same for both parts.
 * The only difference between parts is how to divide the items. This is
 * dealt with the different parsers.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/3">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RucksackReorganization_Solver_Part1
extends RucksackReorganization_Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 3, 1,
            "Rucksack Reorganization", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new RucksackReorganization_Parser_Part1(input);
    }

}
