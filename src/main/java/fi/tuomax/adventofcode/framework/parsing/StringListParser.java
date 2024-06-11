package fi.tuomax.adventofcode.framework.parsing;

import java.util.List;

public class StringListParser 
extends Parser
{

    public StringListParser(List<String> input) {
        super(input);
    }

    @Override
    public void parse() {
        /* Nothing to do. The strings are already stored in the list. */
    }

    public List<String> getStrings()
    {
        return input;
    }
    
}
