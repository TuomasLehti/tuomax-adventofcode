package fi.tuomax.adventofcode.y2015.d02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class IWasToldThereWouldBeNoMath_Parser 
extends Parser
implements Iterable<Present>
{

    private List<Present> presents = new ArrayList<>();

    public IWasToldThereWouldBeNoMath_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            String[] dimensions = line.split("x");
            presents.add(new Present(
                Integer.valueOf(dimensions[0]), 
                Integer.valueOf(dimensions[1]), 
                Integer.valueOf(dimensions[2])
            ));
        }
    }

    @Override
    public Iterator<Present> iterator() 
    {
        return presents.iterator();
    }
    
}
