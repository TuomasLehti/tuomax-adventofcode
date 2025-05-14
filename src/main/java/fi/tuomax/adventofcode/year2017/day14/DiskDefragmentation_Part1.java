package fi.tuomax.adventofcode.year2017.day14;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.year2017.day10.KnotHasher;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 14, part 1:
 * Disk Defragmentation.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/14">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DiskDefragmentation_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 14, 1,
            "Disk Defragmentation", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringParser(input);
    }

    protected List<char[]> prepareDisk()
    {
        List<char[]> disk = new ArrayList<>();
        String input = ((StringParser) parser).getString() + '-';
        for (int i = 0; i < 128; i++) {
            KnotHasher hasher = new KnotHasher();
            String salted = input + i;
            String hash = hasher.getDenseHash(salted);
            disk.add(new BigInteger(hash, 16).toString(2).toCharArray());
        }
        return disk;
    }

    @Override
    protected void solve()
    {
        List<char[]> disk = prepareDisk();

        Integer numOfOnes = 0;
        for (char[] row : disk) {
            for (char col : row) {
                numOfOnes += col - '0';
            }
        }
        setAnswer(numOfOnes);
    }

}
