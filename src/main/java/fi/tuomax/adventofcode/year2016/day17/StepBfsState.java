package fi.tuomax.adventofcode.year2016.day17;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.BfsState;
import fi.tuomax.adventofcode.commons.MD5;

public class StepBfsState 
extends BfsState
{

    private static final Coordinates TARGET = new Coordinates(3L, 3L);

    private String passcode;

    private Coordinates current;
    
    private String path;

    public String getPath() 
    {
        return path;
    }

    public StepBfsState(String passcode)
    {
        super();
        this.passcode = passcode;
        current = Coordinates.ORIGIN;
        path = "";
    }

    private StepBfsState(String passcode, Coordinates current, String path, Integer step)
    {
        this.passcode = passcode;
        this.current = current;
        this.path = path;
        setStep(step);
    }

    @Override
    public Set<BfsState> nextStates() 
    {
        Set<BfsState> nextStates = new HashSet<>();
        if (isTargetState()) return nextStates;

        String md5 = MD5.getMD5(passcode + path, "%32x");

        // up down left right

        if (md5.charAt(0) >= 'b' && current.y() > 0)
            nextStates.add(new StepBfsState(
                passcode, 
                current.translate(new Coordinates(0L, -1L)), 
                path + "U",
                getStep() + 1));

        if (md5.charAt(1) >= 'b' && current.y() < 3)
            nextStates.add(new StepBfsState(
                passcode, 
                current.translate(new Coordinates(0L, 1L)), 
                path + "D",
                getStep() + 1));

        if (md5.charAt(2) >= 'b' && current.x() > 0)
            nextStates.add(new StepBfsState(
                passcode, 
                current.translate(new Coordinates(-1L, 0L)), 
                path + "L",
                getStep() + 1));

        if (md5.charAt(3) >= 'b' && current.x() < 3)
            nextStates.add(new StepBfsState(
                passcode, 
                current.translate(new Coordinates(1L, 0L)), 
                path + "R",
                getStep() + 1));
                        
        return nextStates;
    }

    @Override
    public Boolean isTargetState() 
    {
        return current.equals(TARGET);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof StepBfsState)) return false;
        StepBfsState other = (StepBfsState) o;
        return this.path.equals(other.path);
    }

    @Override
    public int hashCode()
    {
        return path.hashCode();
    }
    
}
