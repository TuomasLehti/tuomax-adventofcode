package fi.tuomax.adventofcode.year2016.day13;

import fi.tuomax.adventofcode.commons.DfsState;

public class CubicleFdsState_Part2 
extends CubicleDfsState
{

    public static Integer targetSteps;

    public CubicleFdsState_Part2()
    {
        super();
    }

    public CubicleFdsState_Part2(CubicleFdsState_Part2 from)
    {
        super(from);
    }

    @Override
    public Boolean isTargetState() 
    {
        return getStep().equals(targetSteps);
    }

    @Override
    protected DfsState manufactureState()
    {
        return new CubicleFdsState_Part2(this);
    }
    
}
