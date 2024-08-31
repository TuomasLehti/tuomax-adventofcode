package fi.tuomax.adventofcode.year2022.day04;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.Range;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class CampCleanup_Parser 
extends Parser 
{

    private List<Range[]> pairs = new ArrayList<>();

    public List<Range[]> getPairs() 
    {
        return pairs;
    }

    public CampCleanup_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            String[] parts = line.split(",|-");
            pairs.add(new Range[]{
                new Range(Long.valueOf(parts[0]), Long.valueOf(parts[1])),
                new Range(Long.valueOf(parts[2]), Long.valueOf(parts[3]))
            });
        }
    }
    
}
