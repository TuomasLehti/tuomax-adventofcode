package fi.tuomax.adventofcode.framework.running;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.printing.ResultCol;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Algorithm;
import fi.tuomax.adventofcode.framework.storing.All;
import fi.tuomax.adventofcode.framework.storing.Day;
import fi.tuomax.adventofcode.framework.storing.Year;

public class DaySpeedRunner 
extends Runner
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer numOfAlgos = 0;

    @Override
    protected List<List<Solver>> collectSolvers(Metadata metadata, All everySolver) {
        List<List<Solver>> runned = new ArrayList<>();
        Year year = everySolver.getYear(metadata.year());
        Day day = year.getDay(metadata.day());
        numOfAlgos = day.getAlgorithmNames().size();
        for (String algoName : day.getAlgorithmNames()) {
            List<Solver> solvers = new ArrayList<>();
            Algorithm algo = day.getAlgorithm(algoName);
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
    protected ResultCol run(Solver solver)
    {
        Long[] times = new Long[5];
        for (int i = 0; i < 5; i++) {
            logger.info(getLogMsg(solver, i));
            solver.run();
            times[i] = solver.getStopwatch().elapsed();
        }
        Long average = (times[0] + times[1] + times[2] + times[3] + times[4]) / 5;
        return new ResultCol(solver.getAnswer(), average, solver);
    }

    protected String getLogMsg(Solver solver, Integer i)
    {
        String fmt = solver.getMetadata().version().isEmpty() 
            ? "Running AoC %d, day %d (%s), part %d"
            : "Running AoC %d, day %d (%s), part %d, %s version";
        return String.format(fmt,
            solver.getMetadata().year(), 
            solver.getMetadata().day(), 
            solver.getMetadata().name(),
            solver.getMetadata().part(), 
            solver.getMetadata().version()) +
            String.format(", pass %d", (i + 1));
    }

    @Override
    protected String getMainHeading(List<List<Solver>> runned) {
        return String.format("Advent of Code %d", runned.get(0).get(0).getMetadata().year());
    }

    @Override
    protected String getSubHeading(List<List<Solver>> runned) {

        Metadata metadata = runned.get(0).get(0).getMetadata();
        if (numOfAlgos > 1)
            return String.format("Day %d: %s", metadata.day(), metadata.name());
        else
            return "";
    }

    @Override
    protected String getRowHeader(List<Solver> row) {
        if (numOfAlgos > 1)
            return row.get(0).getMetadata().version();
        else
            return String.format("Day %d: %s", row.get(0).getMetadata().day(), row.get(0).getMetadata().name());
    }
    
}
