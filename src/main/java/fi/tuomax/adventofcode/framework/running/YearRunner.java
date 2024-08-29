package fi.tuomax.adventofcode.framework.running;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.printing.ResultRow;
import fi.tuomax.adventofcode.framework.printing.Results;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Algorithm;
import fi.tuomax.adventofcode.framework.storing.All;
import fi.tuomax.adventofcode.framework.storing.Day;
import fi.tuomax.adventofcode.framework.storing.Year;

public class YearRunner
extends Runner
{

    @Override
    protected List<List<Solver>> collectSolvers(Metadata metadata, All everySolver) {
        List<List<Solver>> runned = new ArrayList<>();

        Year year = everySolver.getYear(metadata.year());
        for (Integer dayNo : year.getDayNos()) {

            Day day = year.getDay(dayNo);
            String algoName = "";
            if (day.numOfAlgorithms() > 1) {
                algoName = speedTest(day.getMetadata(), everySolver);
            } else {
                algoName = (String) year.getDay(dayNo).getAlgorithmNames().toArray()[0];
            }

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

    private String speedTest(Metadata metadata, All everySolver) 
    {
        DayRunner runner = new DayRunner();
        Results results = runner.run(metadata, everySolver);
        Long fastestTime = Long.MAX_VALUE;
        ResultRow fastestRow = null;
        for (ResultRow row : results.rows()) {
            Long rowTime = row.cols().get(0).time() + (row.cols().get(1).time());
            if (fastestTime > rowTime) {
                fastestRow = row;
                fastestTime = rowTime;
            }
        }
        return fastestRow.name();
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
