package fi.tuomax.adventofcode.framework.parsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Parses Advent of Code input.
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

    public abstract T fromInput(String line);

    @Override
    public Iterator<T> iterator() 
    {
        return objects.iterator();
    }
    
}
