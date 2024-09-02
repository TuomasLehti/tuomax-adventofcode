package fi.tuomax.adventofcode.year2022.day05;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Solves Advent of Code 2022, day 5, part 2:
 * Supply Stacks.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/5">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SupplyStacks_Part2
extends SupplyStacks_Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 5, 2,
            "Supply Stacks", ""
        );
    }

    /**
     * Moves the crates to a temporary stack, which reverses the order. Then
     * moves them to the destination, which unreverses the order back to the
     * original state.
     */
    @Override
    protected void simulateCrateMover() 
    {
        for (StackMove move : moves) {
            Deque<Character> temp = new ArrayDeque<>();
            for (int i = 0; i < move.amount(); i++)
                temp.push(stacks.get(move.from() - 1).pop());
            for (int i = 0; i < move.amount(); i++)
                stacks.get(move.to() - 1).push(temp.pop());
        }
    }

}
