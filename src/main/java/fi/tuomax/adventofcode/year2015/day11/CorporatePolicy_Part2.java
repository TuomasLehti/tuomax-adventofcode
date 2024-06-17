package fi.tuomax.adventofcode.year2015.day11;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class CorporatePolicy_Part2
extends CorporatePolicy
{

    public CorporatePolicy_Part2()
    {
        times = 2;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 11, 2,
            "Corporate Policy", "");
    }

}
