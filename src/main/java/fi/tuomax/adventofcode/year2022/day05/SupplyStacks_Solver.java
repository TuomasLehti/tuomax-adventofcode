package fi.tuomax.adventofcode.year2022.day05;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.Deque;
import java.util.List;

/**
 * <p>Common parts of solving Advent of Code 2022, day 5, part 1:
 * Supply Stacks.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/5">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public abstract class SupplyStacks_Solver
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new SupplyStacks_Parser(input);
    }

    protected List<StackMove> moves;
    
    protected List<Deque<Character>> stacks;

    @Override
    protected void solve()
    {
        moves = ((SupplyStacks_Parser) parser).getMoves();
        stacks = ((SupplyStacks_Parser) parser).getStacks();
        simulateCrateMover();
        StringBuilder answerBuilder = new StringBuilder();
        for (Deque<Character> stack : stacks)
            answerBuilder.append(stack.pop());
        setAnswer(answerBuilder.toString());
    }

    protected abstract void simulateCrateMover();

}
