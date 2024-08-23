package fi.tuomax.adventofcode.commons;

import java.util.Set;

/**
 * A state for depth first searches. Equals method should be implemented,
 * because states won't be added to the queue if they already have been 
 * visited.
 */
public abstract class BfsState 
{

    private Integer step = 0;

    public Integer getStep() 
    {
        return step;
    }

    protected void setStep(Integer step) 
    {
        this.step = step;
    }

    public abstract Set<BfsState> nextStates();

    public abstract Boolean isTargetState();
    
}
