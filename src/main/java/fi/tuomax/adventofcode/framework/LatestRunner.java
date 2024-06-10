package fi.tuomax.adventofcode.framework;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LatestRunner 
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<List<Solver>> run(Metadata metadata, Year year)
    {
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
            run(algo.getPart(1));
            solvers.add(algo.getPart(1));
        }
        if (algo.containsPart(2)) {
            run(algo.getPart(2));
            solvers.add(algo.getPart(2));
        }
        runned.add(solvers);
        return runned;
    }

    private void run(Solver solver)
    {
        logger.info(String.format(
            "Running AoC %d, day %d, part %d: %s", 
            solver.getMetadata().year(), 
            solver.getMetadata().day(), 
            solver.getMetadata().part(), 
            solver.getMetadata().name()));
        solver.run();
}
    
}
