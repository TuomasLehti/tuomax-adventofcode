package fi.tuomax.adventofcode.framework.running;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Algorithm;
import fi.tuomax.adventofcode.framework.storing.Day;
import fi.tuomax.adventofcode.framework.storing.Year;

public class LatestRunner
extends Runner
{

    @Override
    protected List<List<Solver>> collectSolvers(Metadata metadata, Year year) {
        List<List<Solver>> runned = new ArrayList<>();

        if (!year.containsDay(metadata.day()))
            throw new IllegalStateException(String.format("Year %d, day %d not found.", metadata.year(), metadata.day()));

        Day day = year.getDay(metadata.day());
        if (!day.containsAlgorithm(metadata.version()))
            throw new IllegalStateException(String.format("Algorithm %s not found.", metadata.version()));

        Algorithm algo = day.getAlgorithm(metadata.version());

        // Assumes two parts per day for now

        List<Solver> solvers = new ArrayList<>();
        if (algo.containsPart(1)) {
            solvers.add(algo.getPart(1));
        }
        if (algo.containsPart(2)) {
            solvers.add(algo.getPart(2));
        }
        runned.add(solvers);
        return runned;
    }
    
}
