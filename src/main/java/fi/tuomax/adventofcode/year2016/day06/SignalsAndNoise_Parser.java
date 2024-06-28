package fi.tuomax.adventofcode.year2016.day06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class SignalsAndNoise_Parser 
extends Parser
implements Iterable<String>
{

    private List<String> columns = new ArrayList<>();

    public SignalsAndNoise_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        StringBuilder[] cols = new StringBuilder[input.get(0).length()];
        for (int i = 0; i < cols.length; i++)
            cols[i] = new StringBuilder();
        for (String line : input) 
            for (int i = 0; i < line.length(); i++) 
                cols[i].append(line.substring(i, i + 1));
        for (StringBuilder sb : cols)
            columns.add(sb.toString());
    }

    @Override
    public Iterator<String> iterator() 
    {
        return columns.iterator();
    }
    
}
