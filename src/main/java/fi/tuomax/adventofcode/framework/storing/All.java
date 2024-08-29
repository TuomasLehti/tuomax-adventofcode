package fi.tuomax.adventofcode.framework.storing;

import java.util.HashMap;
import java.util.Map;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class All 
{

    public static Metadata latestAddition = null;

    private Map<Integer, Year> years = new HashMap<>();
    
    public void addSolver(Solver solver)
    {
        Metadata meta = solver.getMetadata();
        if (!years.containsKey(meta.year()))
            years.put(meta.year(), new Year());
        years.get(meta.year()).addSolver(solver);
        latestAddition = meta;
    }

    public Boolean containsYear(Integer year)
    {
        return years.containsKey(year);
    }

    public Year getYear(Integer year)
    {
        return years.get(year);
    }

    
}
