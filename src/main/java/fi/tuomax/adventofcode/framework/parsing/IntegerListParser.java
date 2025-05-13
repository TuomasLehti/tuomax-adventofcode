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

    /**
     * Creates a parser for data, which is laid out one integer per line.
     * 
     * @param input
     *      The AoC input.
     */
    public IntegerListParser(List<String> input) 
    {
        super(input);
        this.separator = "";
    }

    public IntegerListParser(List<String> input, String separator)
    {
        super(input);
        this.separator = separator;
    }

    Logger logger = LoggerFactory.getLogger("");

    private List<Integer> ints = new ArrayList<>();

    /**
     * Separator to use when parsing single line data.
     */
    private String separator = "";

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
        if (separator.equals(""))
            for (String line : input)
                parseLine(line);
        else
            for (String line : input.get(0).split(separator))
                parseLine(line.trim());
    }

    @Override
    public Iterator<Integer> iterator() 
    {
        return ints.iterator();
    }

    
}
