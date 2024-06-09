package fi.tuomax.adventofcode.y2015.d01;

import java.util.List;

import fi.tuomax.adventofcode.framework.Metadata;
import fi.tuomax.adventofcode.framework.Parser;
import fi.tuomax.adventofcode.framework.Solver;
import fi.tuomax.adventofcode.framework.StringParser;

public class NotQuiteLisp_Part2 
extends Solver
{

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
        Integer index = 1; // Santa's insturction's indexes are 1-based.
        for (char c : getParser().getString().toCharArray()) {
            if (c == '(')
                floor++;
            else
                floor--;
            if (floor.equals(-1))
                break;
            index++;
        }
        setAnswer(index);
    }

    @Override
    protected Metadata manufactureMetadata() {
        return new Metadata(
            2015, 1, 2, 
            "Not Quite Lisp", 
            "");
    }
    
}
