package fi.tuomax.adventofcode.commons.pathfinding;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.BfsState;
import fi.tuomax.adventofcode.commons.Coordinates;

public class MazeSolverState 
extends BfsState
{

    public static MazeGenerator maze = null;

    public static Coordinates target = null;

    private Coordinates current;

    public MazeSolverState(Coordinates coordinates, Integer step)
    {
        this.current = coordinates;
        this.setStep(step);
    }

    @Override
    public Set<BfsState> nextStates() 
    {
        Set<BfsState> nextStates = new HashSet<>();

        Coordinates up = current.translate(new Coordinates(0L, -1L));
        if (!maze.isWall(up))
            nextStates.add(new MazeSolverState(up, getStep() + 1));

        Coordinates right = current.translate(new Coordinates(1L, -0L));
        if (!maze.isWall(right))
            nextStates.add(new MazeSolverState(right, getStep() + 1));

        Coordinates down = current.translate(new Coordinates(0L, 1L));
        if (!maze.isWall(down))
            nextStates.add(new MazeSolverState(down, getStep() + 1));

        Coordinates left = current.translate(new Coordinates(-1L, 0L));
        if (!maze.isWall(left))
            nextStates.add(new MazeSolverState(left, getStep() + 1));

        return nextStates;
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
        if (o == this) return true;
        if (!(o instanceof MazeSolverState)) return false;
        return current.equals(((MazeSolverState) o).current);
    }
    
}
