package fi.tuomax.adventofcode.framework.running;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.printing.ResultCol;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Algorithm;
import fi.tuomax.adventofcode.framework.storing.Day;
import fi.tuomax.adventofcode.framework.storing.Year;

public class DayRunner 
extends Runner
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected List<List<Solver>> collectSolvers(Metadata metadata, Year year) {
        List<List<Solver>> runned = new ArrayList<>();

        Day day = year.getDay(metadata.day());
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
            logger.info(String.format(
                "Running AoC %d, day %d (%s), part %d, algorithm %s, pass %d", 
                solver.getMetadata().year(), 
                solver.getMetadata().day(), 
                solver.getMetadata().name(),
                solver.getMetadata().part(), 
                solver.getMetadata().version(),
                i));
            solver.run();
            times[i] = solver.getStopwatch().elapsed();
        }
        Long average = (times[0] + times[1] + times[2] + times[3] + times[4]) / 5;
        return new ResultCol(solver.getAnswer(), String.format("%.3f seconds", average/1000f));
    }

    @Override
    protected String getMainHeading(List<List<Solver>> runned) {
        return String.format("Advent of Code %d", runned.get(0).get(0).getMetadata().year());
    }

    @Override
    protected String getSubHeading(List<List<Solver>> runned) {
        Metadata metadata = runned.get(0).get(0).getMetadata();
        return String.format("Day %d: %s", metadata.day(), metadata.name());
    }

    @Override
    protected String getRowHeader(List<Solver> row) {
        return row.get(0).getMetadata().version();
    }
    
}
