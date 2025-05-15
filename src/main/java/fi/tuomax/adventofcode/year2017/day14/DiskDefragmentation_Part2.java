package fi.tuomax.adventofcode.year2017.day14;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 14, part 2:
 * Disk Defragmentation.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/14">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DiskDefragmentation_Part2
extends DiskDefragmentation_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 14, 2,
            "Disk Defragmentation", ""
        );
    }

    @Override
    protected void solve()
    {
        List<char[]> disk = prepareDisk();
        Integer numOfRegions = 0;
        while (countNumOfOnes(disk) > 0) {

            /* Find something to fill. */

            int row = 0;
            int col = 0;
            for (row = 0; row < 128; row++) {
                for (col = 0; col < 128; col++) {
                    if (disk.get(row)[col] == '1') {
                        break;
                    }
                }
                if (col < 128) {
                    break;
                }
            }

            /* Fill it. */

            if (row < 128 && col < 128) {
                numOfRegions++;
                fill(disk, col, row);
            }

        }
        setAnswer(numOfRegions);
    }



    private void fill(List<char[]> disk, int col, int row)
    {
        disk.get(row)[col] = '0';
        if (col > 0 && disk.get(row)[col - 1] == '1') {
            fill(disk, col - 1, row);
        }
        if (col < 127 && disk.get(row)[col + 1] == '1') {
            fill(disk, col + 1, row);
        }
        if (row > 0 && disk.get(row - 1)[col] == '1') {
            fill(disk, col, row - 1);
        }
        if (row < 127 && disk.get(row + 1)[col] == '1') {
            fill(disk, col, row + 1);
        }
    }

}
