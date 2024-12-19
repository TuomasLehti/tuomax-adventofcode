package fi.tuomax.adventofcode.year2024.day18;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.pathfinding.GridMazeGenerator;
import fi.tuomax.adventofcode.commons.pathfinding.MazeSolver;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 18, part 1:
 * RAM Run.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/18">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RamRun_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 18, 1,
            "RAM Run", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new RamRun_Parser(
            input, 
            getParamInt("width"), 
            getParamInt("height"), 
            getParamInt("falling_bytes")
        );
    }

    private RamRun_Parser parser()
    {
        return (RamRun_Parser) parser;
    }

    @Override
    protected void solve()
    {
        GridMazeGenerator.outOfBoundsIsWall = true;
        MazeSolver mazeSolver = new MazeSolver(parser().getGenerator());
        setAnswer(mazeSolver.pathLength(
            Coordinates.ORIGIN,
            Coordinates.fromInteger(getParamInt("width") - 1, getParamInt("height") - 1)
        ));
    }

    @SuppressWarnings("unused")
    private void print()
    {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < getParamInt("height"); row++) {
            for (int col = 0; col < getParamInt("width"); col++)
                if (parser().getGenerator().isWall(Coordinates.fromInteger(col, row)))
                    sb.append("#");
                else
                    sb.append(".");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
