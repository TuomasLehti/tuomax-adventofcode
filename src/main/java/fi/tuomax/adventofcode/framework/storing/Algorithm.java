package fi.tuomax.adventofcode.framework.storing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fi.tuomax.adventofcode.framework.solving.Solver;

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

    public Boolean containsPart(Integer partNo)
    {
        return parts.containsKey(partNo);
    }

    public Solver getPart(Integer partNo)
    {
        return parts.get(partNo);
    }

    public Set<Integer> getPartNos()
    {
        return parts.keySet();
    }
    
}
