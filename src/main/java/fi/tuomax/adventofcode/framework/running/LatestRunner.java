package fi.tuomax.adventofcode.framework.running;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Algorithm;
import fi.tuomax.adventofcode.framework.storing.All;
import fi.tuomax.adventofcode.framework.storing.Day;
import fi.tuomax.adventofcode.framework.storing.Year;

public class LatestRunner
extends Runner
{

    @Override
    protected List<List<Solver>> collectSolvers(Metadata metadata, All everySolver) {
        List<List<Solver>> runned = new ArrayList<>();

        if (!everySolver.containsYear(metadata.year()))
            throw new IllegalStateException(String.format("Year %d not found.", metadata.year()));
        Year year = everySolver.getYear(metadata.year());
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

    @Override
    protected String getMainHeading(List<List<Solver>> runned) {
        return String.format("Advent of Code %d", runned.get(0).get(0).getMetadata().year());
    }

    @Override
    protected String getSubHeading(List<List<Solver>> runned) {
        return "";
    }

    @Override
    protected String getRowHeader(List<Solver> row) {
        return String.format("Day %d: %s", row.get(0).getMetadata().day(), row.get(0).getMetadata().name());
    }

    
}
