package fi.tuomax.adventofcode.year2022.day10;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Grid;

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

        for (int row = 0; row < crtHeight; row++) {
            for (int col = 0; col < crtWidth; col++) {
                int pxIdx = row * crtWidth + col;
                crt.set(col, row, col >= (runningSum.get(pxIdx) - 1) && col <= (runningSum.get(pxIdx) + 1));
            }
        }
        
        if (getParamBool("print_crt")) {
            for (int row = 0; row < crtHeight; row++) {
                for (int col = 0; col < crtWidth; col++) {
                    System.out.print(crt.get(col, row) ? "X" : " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        int spacing = getParamInt("char_width") + getParamInt("char_spacing");
        int numOfChars = crtWidth / spacing;
        String result = "";
        for (int i = 0; i < numOfChars; i++) {
            Grid<Boolean> character = crt.subgrid(
                i * spacing, 0, 
                (i * spacing + getParamInt("char_width")) - 1, crtHeight - 1
            );
            String chrStr = CharacterRecognizer.gridToString(character);
            result += CharacterRecognizer.recognize(chrStr, getParamInt("char_width"), crtHeight);
        }

        setAnswer(result);
    }

}