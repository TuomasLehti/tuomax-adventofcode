package fi.tuomax.adventofcode.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains solvers for all the parts of an Advent of Code puzzle.
 */
public class Algorithm 
{

    private Map<Integer, Solver> parts = new HashMap<>();

    public void addPart(Solver solver)
    {
        parts.put(solver.getMetadata().part(), solver);
    }

    public Solver getPart(Integer partNo)
    {
        return parts.get(partNo);
    }

    public void run()
    {
        for (Integer partNo : parts.keySet())
            parts.get(partNo).run();
    }

    public Long totalTime()
    {
        Long elapsed = 0L;
        for (Integer partNo : parts.keySet())
            elapsed += parts.get(partNo).getStopwatch().elapsed();
        return elapsed;
    }
    
}
