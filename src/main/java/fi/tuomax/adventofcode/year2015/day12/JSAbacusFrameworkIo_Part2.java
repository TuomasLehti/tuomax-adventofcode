package fi.tuomax.adventofcode.year2015.day12;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class JSAbacusFrameworkIo_Part2 
extends JSAbacusFrameworkIo
{

    @Override
    public Boolean abort(Object o) 
    {
        return (o instanceof String) && ((String) o).equals("red");
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 12, 2,
            "JSAbacusFramework.io", ""
        );
    }
    
}
