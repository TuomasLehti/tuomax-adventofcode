package fi.tuomax.adventofcode.framework.storing;

import java.util.HashMap;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class Year 
{

    public static Metadata latestAddition = null;

    private HashMap<Integer, Day> days = new HashMap<>();

    public void addSolver(Solver solver)
    {
        Metadata meta = solver.getMetadata();
        if (!days.containsKey(meta.day()))
            days.put(meta.day(), new Day());
        days.get(meta.day()).addPart(solver);
        latestAddition = meta;
    }

    public Boolean containsDay(Integer day)
    {
        return days.containsKey(day);
    }
    
    public Day getDay(Integer day)
    {
        return days.get(day);
    }

    public void run()
    {
        for (Integer year : days.keySet())
            days.get(year).run();
    }


}
