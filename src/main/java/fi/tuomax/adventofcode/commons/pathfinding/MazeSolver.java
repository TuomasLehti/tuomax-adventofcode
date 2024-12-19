package fi.tuomax.adventofcode.commons.pathfinding;

import fi.tuomax.adventofcode.commons.Bfs;
import fi.tuomax.adventofcode.commons.Coordinates;

public class MazeSolver 
{

    public MazeSolver(MazeGenerator maze)
    {
        MazeSolverState.maze = maze;
    }

    public Integer pathLength(Coordinates from, Coordinates to)
    {
        MazeSolverState.target = to;
        Bfs bfs = new Bfs();
        MazeSolverState finalState = (MazeSolverState) bfs.search(new MazeSolverState(from, 0));
        return finalState.getStep();
    }

    public boolean isSolvable(Coordinates from, Coordinates to) 
    {
        MazeSolverState.target = to;
        Bfs bfs = new Bfs();
        MazeSolverState finalState = (MazeSolverState) bfs.search(new MazeSolverState(from, 0));
        return finalState != null;
    }

}
