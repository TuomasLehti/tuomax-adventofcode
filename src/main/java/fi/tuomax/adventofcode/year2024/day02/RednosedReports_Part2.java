package fi.tuomax.adventofcode.year2024.day02;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 2, part 2:
 * Red-Nosed Reports.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/2">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RednosedReports_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 2, 2,
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
        for (List<Integer> report : reports) {
            if (ReportEvaluator.isSafe(report)) {
                sum++;
                continue;
            }
            for (int removeIdx = 0; removeIdx < report.size(); removeIdx++) {
                List<Integer> cousin = new ArrayList<>(report);
                cousin.remove(removeIdx);
                if (ReportEvaluator.isSafe(cousin)) {
                    sum++;
                    break;
                }
            }
        }
        setAnswer(sum);
    }

}
