package fi.tuomax.adventofcode.year2015.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class NoSuchThingAsTooMuch_Parser 
extends Parser
{

    Container container = null;

    public Container getContainer() 
    {
        return container;
    }

    public NoSuchThingAsTooMuch_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        List<Integer> containers = new ArrayList<>();
        for (String line : input) {
            containers.add(Integer.valueOf(line));
        }
        Collections.sort(containers);
        Collections.reverse(containers);
        for (Integer i : containers) {
            if (container == null)
                container = new Container(i);
            else    
                container.add(new Container(i));
        }
    }
    
}
