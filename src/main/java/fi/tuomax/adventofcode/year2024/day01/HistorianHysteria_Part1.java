package fi.tuomax.adventofcode.year2024.day01;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.Collections;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 1, part 1:
 * Historian Hysteria.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/1">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class HistorianHysteria_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 1, 1,
            "Historian Hysteria", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new HistorianHysteria_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Integer> left = ((HistorianHysteria_Parser) parser).getLeft();
        List<Integer> right = ((HistorianHysteria_Parser) parser).getRight();

        Collections.sort(left);
        Collections.sort(right);

        Long sumOfDifferences = 0L;
        for (int i = 0; i < left.size(); i++)
            sumOfDifferences += Math.abs(right.get(i) - left.get(i));
        
        setAnswer(sumOfDifferences);
    }

}
