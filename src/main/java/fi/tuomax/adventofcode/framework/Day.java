package fi.tuomax.adventofcode.framework;

import java.util.HashMap;
import java.util.Map;

public class Day 
{

    /**
     * The solvers for the different parts of an Aoc puzzle. There usually are
     * two parts per day, but this data structure works even if there are more.
     */
    private Map<Integer, Map<String, Solver>> parts = new HashMap<>();

    public void addPart(Solver part)
    {
        if (!parts.containsKey(part.getMetadata().part()))
            parts.put(part.getMetadata().part(), new HashMap<>());
        parts.get(part.getMetadata().part()).put(part.getMetadata().version(), part);
    }
    
}
