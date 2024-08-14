package fi.tuomax.adventofcode.year2016.day19;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

public abstract class AnElephantNamedJoseph 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    @Override
    protected void solve() 
    {
        Integer numOfElves = Integer.valueOf(((StringParser) parser).getString());
        Elf.create(numOfElves);

        Elf turn = Elf.head;
        Elf from = stealFrom(turn);
        while (turn.steal(from)) {
            turn = turn.left;
            from = stealFrom(turn);
        }
        setAnswer(turn.num);
    }

    protected abstract Elf stealFrom(Elf inTurn);
    
}
