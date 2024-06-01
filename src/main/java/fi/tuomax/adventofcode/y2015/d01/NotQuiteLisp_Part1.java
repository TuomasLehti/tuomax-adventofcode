package fi.tuomax.adventofcode.y2015.d01;

import java.util.List;

import fi.tuomax.adventofcode.framework.Metadata;
import fi.tuomax.adventofcode.framework.Parser;
import fi.tuomax.adventofcode.framework.Solver;
import fi.tuomax.adventofcode.framework.StringParser;

public class NotQuiteLisp_Part1 
extends Solver
{

    public NotQuiteLisp_Part1(List<String> input) 
    {
        super(input);
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    private StringParser getParser()
    {
        return (StringParser) parser;
    }

    @Override
    protected void solve() 
    {
        Integer floor = 0;
        for (char c : getParser().getString().toCharArray()) {
            if (c == '(')
                floor++;
            else
                floor--;
        }
        setAnswer(floor);
    }

    @Override
    protected Metadata manufactureMetadata() {
        return new Metadata(
            2015, 1, 1, 
            "Not Quite Lisp", 
            "");
    }
    
}
