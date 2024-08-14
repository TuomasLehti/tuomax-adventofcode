package fi.tuomax.adventofcode.year2016.day19;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class AnElephantNamedJoseph_Part1 
extends AnElephantNamedJoseph
{
    
    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 19, 1,
            "An Elephant Named Joseph", ""
        );
    }

    @Override
    protected Elf stealFrom(Elf inTurn) 
    {
        return inTurn.left;
    }
    
}
