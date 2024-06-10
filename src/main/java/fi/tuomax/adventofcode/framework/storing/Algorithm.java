package fi.tuomax.adventofcode.framework.storing;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Contains solvers for all the parts of an Advent of Code puzzle.
 */
public class Algorithm 
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<Integer, Solver> parts = new HashMap<>();

    public void addPart(Solver solver)
    {
        parts.put(solver.getMetadata().part(), solver);
    }

    public Boolean containsPart(Integer partNo)
    {
        return parts.containsKey(partNo);
    }

    public Solver getPart(Integer partNo)
    {
        return parts.get(partNo);
    }

    public void run()
    {
        for (Integer partNo : parts.keySet()) {
            Solver part = parts.get(partNo);
            logger.info(String.format(
                "Running AoC %d, day %d, part %d: %s", 
                part.getMetadata().year(), 
                part.getMetadata().day(), 
                part.getMetadata().part(), 
                part.getMetadata().name()));
            part.run();
        }
    }

    public Long totalTime()
    {
        Long elapsed = 0L;
        for (Integer partNo : parts.keySet())
            elapsed += parts.get(partNo).getStopwatch().elapsed();
        return elapsed;
    }
    
}
