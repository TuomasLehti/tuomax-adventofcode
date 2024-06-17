package fi.tuomax.adventofcode.year2015.day11;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class CorporatePolicy_Part1 
extends CorporatePolicy
{

    public CorporatePolicy_Part1()
    {
        times = 1;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 11, 1,
            "Corporate Policy", "");
    }

}
