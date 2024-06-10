package fi.tuomax.adventofcode.framework.running;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.printing.ResultCol;
import fi.tuomax.adventofcode.framework.printing.ResultRow;
import fi.tuomax.adventofcode.framework.printing.Results;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.framework.storing.Year;

public abstract class Runner
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    public Results run(Metadata metadata, Year year)
    {
        List<List<Solver>> runned = collectSolvers(metadata, year);
        List<ResultRow> resultRows = new ArrayList<>();
        for (List<Solver> row : runned) {
            List<ResultCol> resultCols = new ArrayList<>();
            for (Solver solver : row) {
                resultCols.add(run(solver));
            }
            resultRows.add(new ResultRow(getRowHeader(row), resultCols));
        }
        return new Results(getMainHeading(runned), getSubHeading(runned), resultRows);
    }


    protected abstract String getMainHeading(List<List<Solver>> runned);

    protected abstract String getSubHeading(List<List<Solver>> runned);

    protected abstract String getRowHeader(List<Solver> row);

    protected abstract List<List<Solver>> collectSolvers(Metadata metadata, Year year);

    private ResultCol run(Solver solver)
    {
        logger.info(String.format(
            "Running AoC %d, day %d (%s), part %d, algorithm %s", 
            solver.getMetadata().year(), 
            solver.getMetadata().day(), 
            solver.getMetadata().name(),
            solver.getMetadata().part(), 
            solver.getMetadata().version()));
        solver.run();
        return new ResultCol(solver.getAnswer(), solver.getStopwatch().toString());
}
    
}
