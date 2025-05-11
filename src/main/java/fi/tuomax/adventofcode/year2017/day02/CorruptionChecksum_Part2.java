package fi.tuomax.adventofcode.year2017.day02;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 2, part 2:
 * Corruption Checksum.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/2">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CorruptionChecksum_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 2, 2,
            "Corruption Checksum", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new IntegerArrayParser(input);
    }

    @Override
    protected void solve()
    {
        List<List<Integer>> intss = ((IntegerArrayParser) parser).getInts();
        int ans = 0;
        rowLoop : for (List<Integer> ints : intss) {
            for (int i = 0; i < ints.size() - 1; i++) {
                for (int j = i + 1; j < ints.size(); j++) {
                    int subans = 0;
                    if ((ints.get(i) % ints.get(j)) == 0) {
                        subans = ints.get(i) / ints.get(j);
                    } else if ((ints.get(j) % ints.get(i)) == 0) {
                        subans = ints.get(j) / ints.get(i);
                    }
                    if (subans > 0) {
                        ans += subans;
                        continue rowLoop; // only one valid pair per line
                    }
                }
            }
        }
        setAnswer(ans);
    }

}
