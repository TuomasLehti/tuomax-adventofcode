package fi.tuomax.adventofcode.framework;

import java.util.List;

/**
 * <p>Base class for parsing Advent of Code input.</p>
 * 
 * <p>The child classes should of course override the parse-method and have
 * methods for the solver to access the parsed input.</p>
 */
public abstract class Parser 
{

    protected List<String> input;

    public Parser(List<String> input)
    {
        this.input = input;
    }

    protected abstract void parse();
    
}
