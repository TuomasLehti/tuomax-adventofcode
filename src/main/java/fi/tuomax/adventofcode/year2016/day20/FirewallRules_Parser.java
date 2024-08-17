package fi.tuomax.adventofcode.year2016.day20;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fi.tuomax.adventofcode.commons.Range;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class FirewallRules_Parser 
extends Parser
implements Iterable<Range>
{

    private List<Range> ranges = new ArrayList<>();

    public FirewallRules_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            String[] parts = line.split("-");
            Long start = Long.valueOf(parts[0]);
            Long end = Long.valueOf(parts[1]);
            ranges.add(new Range(start, end));
        }
    }

    @Override
    public Iterator<Range> iterator() 
    {
        return ranges.iterator();
    }
    
}
