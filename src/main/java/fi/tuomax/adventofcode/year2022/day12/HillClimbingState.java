package fi.tuomax.adventofcode.year2022.day12;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.BfsState;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Grid;

public class HillClimbingState 
extends BfsState
{

    public static Grid<Integer> map = null;

    public static Coordinates target = null;

    private Coordinates current;

    public HillClimbingState(Coordinates current, Integer step)
    {
        this.current = current;
        setStep(step);
    }

    @Override
    public Set<BfsState> nextStates() 
    {
        Set<BfsState> states = new HashSet<>();
        Coordinates temp = getStep(Direction.getInstance(Direction.NORTH));
        if (isStepAvailable(temp)) {
            states.add(new HillClimbingState(temp, getStep() + 1));
        }
        temp = getStep(Direction.getInstance(Direction.EAST));
        if (isStepAvailable(temp)) {
            states.add(new HillClimbingState(temp, getStep() + 1));
        }
        temp = getStep(Direction.getInstance(Direction.SOUTH));
        if (isStepAvailable(temp)) {
            states.add(new HillClimbingState(temp, getStep() + 1));
        }
        temp = getStep(Direction.getInstance(Direction.WEST));
        if (isStepAvailable(temp)) {
            states.add(new HillClimbingState(temp, getStep() + 1));
        }
        return states;
    }

    private Boolean isStepAvailable(Coordinates stepTo)
    {
        return
            map.exists(stepTo.xAsInt(), stepTo.yAsInt()) &&
            (map.get(stepTo.xAsInt(), stepTo.yAsInt())
                <= map.get(current.xAsInt(), current.yAsInt()) + 1);
    }

    private Coordinates getStep(Direction to)
    {
        return current.translate(to.asCoordinates());
    }

    @Override
    public Boolean isTargetState() 
    {
        return current.equals(target);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof HillClimbingState)) return false;
        HillClimbingState other = (HillClimbingState) o;
        return this.current.equals(other.current);
    }
    
}
