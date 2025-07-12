package fi.tuomax.adventofcode.year2017.day23;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.NoopParser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 23, part 2:
 * Coprocessor Conflagration.</p>
 * 
 * <p>The assembly program counts the number of composite numbers between
 * two large numbers in steps of 17. In this solution the routine is converted
 * to Java and the original input is ignored altogether.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/23">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CoprocessorConflagration_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 23, 2,
            "Coprocessor Conflagration", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new NoopParser(input);
    }

    private Boolean isPrime(Long num)
    {
        Long target = Math.round(Math.sqrt(num)) + 1;
        for (long factor = 2; factor < target; factor++)
            if (num % factor == 0) return false;
        return true;
    }

    @Override
    protected void solve()
    {
        long ans = 0;
        for (long num = 108_100; num <= 125_100; num += 17) 
            if (!isPrime(num)) ans++;
        setAnswer(ans);
    }

}
