package fi.tuomax.adventofcode.y2015.d02;

import fi.tuomax.adventofcode.framework.Metadata;

public class IWasToldThereWouldBeNoMath_Part1 
extends IWasToldThereWouldBeNoMath_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 2, 1, 
            "I Was Told There Would Be No Math", 
            "");
    }

    @Override
    protected Integer calculation(Present present) 
    {
        Integer frontArea = present.width() * present.height();
        Integer topArea = present.length() * present.width();
        Integer sideArea = present.length() * present.height();
        return (2 * frontArea + 2 * topArea + 2 * sideArea + 
                minimum(frontArea, topArea, sideArea));
    }
    
}
