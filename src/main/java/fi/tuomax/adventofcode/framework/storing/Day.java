package fi.tuomax.adventofcode.framework.storing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class Day 
{

    /**
     * The solvers for the different parts of an Aoc puzzle. There usually are
     * two parts per day, but this data structure works even if there are more.
     */
    private Map<String, Algorithm> algorithms = new HashMap<>();

    private Metadata metadata = null;

    public Metadata getMetadata() {
        return metadata;
    }

    public void addPart(Solver part)
    {
        if (!algorithms.containsKey(part.getMetadata().version()))
            algorithms.put(part.getMetadata().version(), new Algorithm());
        algorithms.get(part.getMetadata().version()).addPart(part);
        metadata = new Metadata(
            part.getMetadata().year(), 
            part.getMetadata().day(),
            null,
            null,
            null);
    }

    public Boolean containsAlgorithm(String algorithmName)
    {
        return algorithms.containsKey(algorithmName);
    }

    public Algorithm getAlgorithm(String algorithmName)
    {
        return algorithms.get(algorithmName);
    }

    public Set<String> getAlgorithmNames() 
    {
        return algorithms.keySet();
    }

    public Integer numOfAlgorithms()
    {
        return algorithms.size();
    }

}
