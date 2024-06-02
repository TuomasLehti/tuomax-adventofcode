package fi.tuomax.adventofcode.framework;

import java.util.HashMap;

public class Year 
{

    private HashMap<Integer, Day> days = new HashMap<>();

    public void addSolver(Solver solver)
    {
        Metadata meta = solver.getMetadata();
        if (!days.containsKey(meta.day()))
            days.put(meta.day(), new Day());
        days.get(meta.day()).addPart(solver);
    }
    
}
