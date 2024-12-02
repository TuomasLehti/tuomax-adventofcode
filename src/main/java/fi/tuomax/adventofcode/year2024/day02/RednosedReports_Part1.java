package fi.tuomax.adventofcode.year2024.day02;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2024, day 2, part 1:
 * Red-Nosed Reports.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/2">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RednosedReports_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 2, 1,
            "Red-Nosed Reports", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new RednosedReports_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<List<Integer>> reports = ((RednosedReports_Parser) parser).getReports();
        Integer sum = 0;
        Integer idx = 0;
        for (List<Integer> report : reports) {
            LoggerFactory.getLogger(getClass()).debug(idx + " is " + ReportEvaluator.isSafe(report));
            if (ReportEvaluator.isSafe(report)) sum++;
        }
        setAnswer(sum);
    }

    

}
