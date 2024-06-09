package fi.tuomax.adventofcode.y2015.d02;

import fi.tuomax.adventofcode.framework.Metadata;

public class IWasToldThereWouldBeNoMath_Part2 
extends IWasToldThereWouldBeNoMath_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 2, 2, 
            "I Was Told There Would Be No Math", 
            "");
    }

    @Override
    protected Integer calculation(Present present) 
    {
        Integer frontPerimeter = 2 * present.width() + 2 * present.height();
        Integer topPerimeter = 2 * present.length() + 2 * present.width();
        Integer sidePerimeter = 2 * present.length() + 2 * present.height();
        return minimum(frontPerimeter, topPerimeter, sidePerimeter) + 
                present.length() * present.width() * present.height();
    }
    
}
