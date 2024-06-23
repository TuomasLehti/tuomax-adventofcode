package fi.tuomax.adventofcode.framework.parsing;

import java.util.List;

/** 
 * A no-operation parser.
 */
public class NoopParser 
extends Parser
{

    public NoopParser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
    }
    
}
