package fi.tuomax.adventofcode.year2015.day11;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

public abstract class CorporatePolicy 
extends Solver
{

    protected Integer times = 1;

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    @Override
    protected void solve() 
    {
        Password password = new Password(((StringParser) parser).getString());
        for (int i = 0; i < times; i++)
            password.incrementToNextValid();
        setAnswer(password.getPassword());
    }

    
}
