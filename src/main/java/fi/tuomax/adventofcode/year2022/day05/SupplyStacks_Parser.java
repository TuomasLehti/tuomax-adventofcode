package fi.tuomax.adventofcode.year2022.day05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class SupplyStacks_Parser 
extends Parser
{

    private List<StackMove> moves = new ArrayList<>();

    public List<StackMove> getMoves() 
    {
        return moves;
    }

    private List<Deque<Character>> stacks = new ArrayList<>();

    public List<Deque<Character>> getStacks() 
    {
        return stacks;
    }

    public SupplyStacks_Parser(List<String> input) 
    {
        super(input);
    }

    private enum ParseState { STACKS, MOVES };

    private ParseState state = ParseState.STACKS;

    @Override
    public void parse() 
    {
        for (String line : input) {
            if (line.isEmpty()) {
                state = ParseState.MOVES;
            } else if (state == ParseState.STACKS) {
                fillStacks(line);
            } else if (state == ParseState.MOVES) {
                moves.add(StackMove.fromInput(line));
            }
        }
    }

    private void fillStacks(String line) 
    {
        if (!line.contains("["))
            return;
        Integer numOfStacks = (line.length() + 1) / 4;
        for (int i = 0; i < numOfStacks; i++) {
            Character item = line.charAt((i * 4) + 1);
            if (i >= stacks.size())
                stacks.add(new ArrayDeque<>());
            if (!item.equals(' '))
                stacks.get(i).addLast(item);
        }
    }

}
