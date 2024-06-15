package fi.tuomax.adventofcode.year2015.day10;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class ElvesLookElvesSay_Part1 
extends Solver
{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015,
            10,
            1,
            "Elves Look, Elves Say",
            ""
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
        String input = ((StringParser) parser).getString();
        for (int i = 0; i < 40; i++) {
            input = LookAndSay.lookAndSay(input);
        }
        setAnswer(input.length());
    }
    
}
