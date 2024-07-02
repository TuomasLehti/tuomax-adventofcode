package fi.tuomax.adventofcode.framework.parsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Parses Advent of Code input, in which a row of input can be mapped into a
 * single object.
 */
public abstract class ParseableParser<T extends Parseable>
extends Parser
implements Iterable<T>
{

    List<T> objects = new ArrayList<>();

    public ParseableParser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input)
            objects.add(fromInput(line));
    }

    /** A factory method to manufacture a Parseable object from a line of input. */
    public abstract T fromInput(String line);

    @Override
    public Iterator<T> iterator() 
    {
        return objects.iterator();
    }
    
}
