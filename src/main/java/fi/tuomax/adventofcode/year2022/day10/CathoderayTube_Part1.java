package fi.tuomax.adventofcode.year2022.day10;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 10, part 1:
 * Cathode-Ray Tube.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/10">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CathoderayTube_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 10, 1,
            "Cathode-Ray Tube", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringListParser(input);
    }

    public List<Integer> runningSum = new ArrayList<>();

    @Override
    protected void solve()
    {
        List<String> instructions = ((StringListParser) parser).getStrings();
        List<Integer> additions = new ArrayList<>();

        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");
            if (parts[0].equals("noop")) {
                additions.add(0);
            } else if (parts[0].equals("addx")) {
                additions.add(0);
                additions.add(Integer.valueOf(parts[1]));
            }
        }

        int signalStrength = 1;
        for (Integer addition : additions) {
            runningSum.add(signalStrength);
            signalStrength += addition;
        }
        runningSum.add(signalStrength);

        setAnswer(
            runningSum.get(19) * 20 +
            runningSum.get(59) * 60 +
            runningSum.get(99) * 100 +
            runningSum.get(139) * 140 +
            runningSum.get(179) * 180 +
            runningSum.get(219) * 220
        );


    }

}
