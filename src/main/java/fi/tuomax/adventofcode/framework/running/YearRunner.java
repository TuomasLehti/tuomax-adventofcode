package fi.tuomax.adventofcode.framework.running;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Algorithm;
import fi.tuomax.adventofcode.framework.storing.Year;

public class YearRunner 
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<List<Solver>> run(Metadata metadata, Year year)
    {
        List<List<Solver>> runned = new ArrayList<>();

        for (Integer dayNo : year.getDayNos()) {
            String algoName = (String) year.getDay(dayNo).getAlgorithmNames().toArray()[0];
            Algorithm algo = year.getDay(dayNo).getAlgorithm(algoName);

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
        }

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
