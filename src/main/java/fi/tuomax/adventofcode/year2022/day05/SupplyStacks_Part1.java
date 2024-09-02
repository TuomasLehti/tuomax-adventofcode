package fi.tuomax.adventofcode.year2022.day05;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2022, day 5, part 1:
 * Supply Stacks.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/5">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SupplyStacks_Part1
extends SupplyStacks_Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 5, 1,
            "Supply Stacks", ""
        );
    }

    /**
     * Simply simulates moving single crates around.
     */
    @Override
    protected void simulateCrateMover() {
        for (StackMove move : moves)
            for (int i = 0; i < move.amount(); i++)
                stacks.get(move.to() - 1).push(stacks.get(move.from() - 1).pop());
    }

}
