package fi.tuomax.adventofcode.framework.running;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Algorithm;
import fi.tuomax.adventofcode.framework.storing.Year;

public class YearRunner
extends Runner
{

    @Override
    protected List<List<Solver>> collectSolvers(Metadata metadata, Year year) {
        List<List<Solver>> runned = new ArrayList<>();

        for (Integer dayNo : year.getDayNos()) {
            String algoName = (String) year.getDay(dayNo).getAlgorithmNames().toArray()[0];
            Algorithm algo = year.getDay(dayNo).getAlgorithm(algoName);

            // Assumes two parts per day for now

            List<Solver> solvers = new ArrayList<>();
            if (algo.containsPart(1)) {
                solvers.add(algo.getPart(1));
            }
            if (algo.containsPart(2)) {
                solvers.add(algo.getPart(2));
            }
            runned.add(solvers);
        }

        return runned;
    }

    @Override
    protected String getMainHeading(List<List<Solver>> runned) {
        Metadata metadata = runned.get(0).get(0).getMetadata();
        return String.format("Advent of Code %d", metadata.year());
    }

    @Override
    protected String getSubHeading(List<List<Solver>> runned) {
        return "";
    }

    @Override
    protected String getRowHeader(List<Solver> row) {
        Metadata metadata = row.get(0).getMetadata();
        return String.format("Day %d: %s", metadata.day(), metadata.name());
    }
    
}
