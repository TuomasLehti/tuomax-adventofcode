package fi.tuomax.adventofcode.year2016.day19;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class AnElephantNamedJoseph 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 19, 1,
            "An Elephant Named Joseph", ""
        );
    }

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
        while (turn.steal()) {
            do {
                turn = turn.left;
            } while (turn.numOfPresents == 0);
        }
        setAnswer(turn.num);

    }
    
}
