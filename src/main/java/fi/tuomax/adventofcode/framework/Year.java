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
