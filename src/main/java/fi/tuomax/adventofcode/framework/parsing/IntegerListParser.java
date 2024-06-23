package fi.tuomax.adventofcode.framework.parsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parses Advent of Code input into a list of integers. Each integer should be
 * in its own line. If a line can't be converted to an integer, the line is
 * skipped and a log message is printed.
 */
public class IntegerListParser 
extends Parser
implements Iterable<Integer>
{

    public IntegerListParser(List<String> input) 
    {
        super(input);
    }

    Logger logger = LoggerFactory.getLogger("");

    private List<Integer> ints = new ArrayList<>();

    public List<Integer> getIntegers()
    {
        return ints;
    }

    protected void parseLine(String token) {
        try {
            ints.add(Integer.valueOf(token));
        } catch (NumberFormatException e) {
            logger.warn(
                "Number formatting error! " +
                e.getMessage() + "."
            );
        }
    }

    @Override
    public void parse() 
    {
        for (String line : input)
            parseLine(line);
    }

    @Override
    public Iterator<Integer> iterator() {
        return ints.iterator();
    }

    
}
