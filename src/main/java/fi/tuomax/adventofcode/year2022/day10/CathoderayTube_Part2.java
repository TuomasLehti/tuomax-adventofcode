package fi.tuomax.adventofcode.year2022.day10;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringListParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 10, part 2:
 * Cathode-Ray Tube.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/10">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CathoderayTube_Part2
extends CathoderayTube_Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 10, 2,
            "Cathode-Ray Tube", ""
        );
    }

    @Override
    protected void solve()
    {
        super.solve();
        int crtWidth = getParamInt("crt_width");
        int crtHeight = getParamInt("crt_height");
        Grid<Boolean> crt = new Grid<>(crtWidth, crtHeight);

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < crtHeight; row++) {
            for (int col = 0; col < crtWidth; col++) {
                int pxIdx = row * crtWidth + col;
                crt.set(col, row, col < (runningSum.get(pxIdx) - 1) || col > (runningSum.get(pxIdx) + 1));
            }
        }

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
