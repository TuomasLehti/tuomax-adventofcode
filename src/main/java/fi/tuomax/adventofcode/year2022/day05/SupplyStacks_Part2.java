package fi.tuomax.adventofcode.year2022.day05;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 5, part 2:
 * Supply Stacks.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/5">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SupplyStacks_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 5, 2,
            "Supply Stacks", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new SupplyStacks_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<StackMove> moves = ((SupplyStacks_Parser) parser).getMoves();
        List<Deque<Character>> stacks = ((SupplyStacks_Parser) parser).getStacks();
        for (StackMove move : moves) {
            Deque<Character> temp = new ArrayDeque<>();
            for (int i = 0; i < move.amount(); i++)
                temp.push(stacks.get(move.from() - 1).pop());
            for (int i = 0; i < move.amount(); i++)
                stacks.get(move.to() - 1).push(temp.pop());
        }
        StringBuilder answerBuilder = new StringBuilder();
        for (Deque<Character> stack : stacks)
            answerBuilder.append(stack.pop());
        setAnswer(answerBuilder.toString());
    }

}
