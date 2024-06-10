package fi.tuomax.adventofcode.framework.storing;

import java.util.HashMap;
import java.util.Map;

import fi.tuomax.adventofcode.framework.solving.Solver;

public class Day 
{

    /**
     * The solvers for the different parts of an Aoc puzzle. There usually are
     * two parts per day, but this data structure works even if there are more.
     */
    private Map<String, Algorithm> algorithms = new HashMap<>();

    public void addPart(Solver part)
    {
        if (!algorithms.containsKey(part.getMetadata().version()))
            algorithms.put(part.getMetadata().version(), new Algorithm());
        algorithms.get(part.getMetadata().version()).addPart(part);
    }

    public Boolean containsAlgorithm(String algorithmName)
    {
        return algorithms.containsKey(algorithmName);
    }

    public Algorithm getAlgorithm(String algorithmName)
    {
        return algorithms.get(algorithmName);
    }

    public void run()
    {
        for (Algorithm algo : algorithms.values())
            algo.run();
    }
    
}
