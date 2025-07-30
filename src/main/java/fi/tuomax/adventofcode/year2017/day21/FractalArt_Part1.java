package fi.tuomax.adventofcode.year2017.day21;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.SparseBooleanGrid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 21, part 1:
 * Fractal Art.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/21">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class FractalArt_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 21, 1,
            "Fractal Art", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new FractalArt_Parser(input);
    }

    @Override
    protected void solve()
    {
        EnhancementRuleBook rules = ((FractalArt_Parser) parser).getRules();
        SparseBooleanGrid original = new SparseBooleanGrid(
            getParamStr("start_pattern"), "/", '#'
        );
        Integer numOfIterations = getParamInt("iterations");
        for (int i = 0; i < numOfIterations; i++) {
            System.out.println(i + ": " + original.width());
/*             System.out.println("=========");
            System.out.println(original.asString("#", ".", "", "\n")); */
            SparseBooleanGrid result = new SparseBooleanGrid();
            if (original.width() % 2 == 0) {
                long chunkRow = 0;
                long chunkCol = 0;
                for (long row = original.getTopLeft().y(); original.getBottomRight().y() < row; row -= 2) {
                    for (long col = original.getTopLeft().x(); col < original.getBottomRight().x(); col += 2) {
                        SparseBooleanGrid subgrid = (SparseBooleanGrid) original.subgrid(
                            new Coordinates(col, row),
                            new Coordinates(col + 2, row - 2)
                        );
                        subgrid.translate(new Coordinates(
                            -col, -row
                        ));
/*                         System.out.println("-----");
                        System.out.println(subgrid.asString("#", ".", "", "\n"));
 */                        EnhancementRule enhancement = rules.get(subgrid);
                        SparseBooleanGrid output = enhancement.getOutputPattern().copy();
/*                         System.out.println("<<<---");
                        System.out.println(enhancement.getInputPattern().asString("#", ".", "", "\n"));
                        System.out.println("--->>>");
                        System.out.println(output.asString("#", ".", "", "\n"));
 */                        output.normalize();
                        Coordinates translationAmount = new Coordinates(
                            chunkCol * 3, chunkRow * 3
                        );
                        output.translate(translationAmount);
                        result.addAll(output);
                        chunkCol++;
                    }
                    chunkRow--;
                    chunkCol = 0;
                }
            } else if (original.width() % 3 == 0) {
                long chunkRow = 0;
                long chunkCol = 0;
                for (long row = original.getTopLeft().y(); original.getBottomRight().y() < row; row -= 3) {
                    for (long col = original.getTopLeft().x(); col < original.getBottomRight().x(); col += 3) {
                        SparseBooleanGrid subgrid = (SparseBooleanGrid) original.subgrid(
                            new Coordinates(col, row),
                            new Coordinates(col + 3, row - 3)
                        );
                        subgrid.translate(new Coordinates(
                            -col, -row
                        ));
/*                         System.out.println("-----");
                        System.out.println(subgrid.asString("#", ".", "", "\n"));
 */                        EnhancementRule enhancement = rules.get(subgrid);
                        SparseBooleanGrid output = enhancement.getOutputPattern().copy();
/*                         System.out.println("<<<---");
                        System.out.println(enhancement.getInputPattern().asString("#", ".", "", "\n"));
                        System.out.println("--->>>");
                        System.out.println(output.asString("#", ".", "", "\n"));
 */                        output.normalize();
                        Coordinates translationAmount = new Coordinates(
                            chunkCol * 4, chunkRow * 4
                        );
                        output.translate(translationAmount);
                        result.addAll(output);
                        chunkCol++;
                    }
                    chunkRow--;
                    chunkCol = 0;
                }
            }
            original = result;
        }
        long ans = 0;
        for (long rowIdx = original.height() - 1; rowIdx >= 0; rowIdx--)
            for (long colIdx = 0; colIdx < original.width(); colIdx++) {
                Coordinates pos = new Coordinates(colIdx, -rowIdx);
                if (original.get(pos) != null && original.get(pos))
                    ans++;
            }
        setAnswer(ans);
    }

}
// 143 too high