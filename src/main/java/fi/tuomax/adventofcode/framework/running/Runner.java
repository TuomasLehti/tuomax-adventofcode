package fi.tuomax.adventofcode.framework.running;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Year;

public abstract class Runner
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<List<Solver>> run(Metadata metadata, Year year)
    {
        List<List<Solver>> runned = collectSolvers(metadata, year);
        for (List<Solver> row : runned) {
            for (Solver solver : row) {
                run(solver);
            }
        }
        return runned;
    }

    protected abstract List<List<Solver>> collectSolvers(Metadata metadata, Year year);

    private void run(Solver solver)
    {
        logger.info(String.format(
            "Running AoC %d, day %d (%s), part %d, algorithm %s", 
            solver.getMetadata().year(), 
            solver.getMetadata().day(), 
            solver.getMetadata().name(),
            solver.getMetadata().part(), 
            solver.getMetadata().version()));
        solver.run();
}
    
}
