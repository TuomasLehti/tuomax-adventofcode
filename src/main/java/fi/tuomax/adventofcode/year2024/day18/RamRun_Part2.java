package fi.tuomax.adventofcode.year2024.day18;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.commons.pathfinding.GridMazeGenerator;
import fi.tuomax.adventofcode.commons.pathfinding.MazeGenerator;
import fi.tuomax.adventofcode.commons.pathfinding.MazeSolver;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2024, day 18, part 2:
 * RAM Run.</p>
 * 
 * TODO: optimize
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/18">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RamRun_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 18, 2,
            "RAM Run", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new Coordinatess_Parser(input);
    }

    private Coordinatess_Parser parser()
    {
        return (Coordinatess_Parser) parser;
    }

    @Override
    protected void solve()
    {
        int width = getParamInt("width");
        int height = getParamInt("height");
        Grid<Boolean> grid = new Grid<>(width, height);
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                grid.set(col, row, false);

        GridMazeGenerator.outOfBoundsIsWall = true;
        int i = 0;

        for (i = 0; i < 1024; i++) {
            grid.set(parser().getCoords().get(i), true);
        }
        i--;
        MazeGenerator generator = new GridMazeGenerator(grid);
        print(generator);
        MazeSolver mazeSolver = null;
        Coordinates from = Coordinates.ORIGIN;
        Coordinates to = Coordinates.fromInteger(getParamInt("width") - 1, getParamInt("height") - 1);
        do {
            i++;
            LoggerFactory.getLogger(getClass()).debug("Byte " + i + "...");
            grid.set(parser().getCoords().get(i), true);
            generator = new GridMazeGenerator(grid);
            mazeSolver = new MazeSolver(generator);
        } while (mazeSolver.isSolvable(from, to));
        setAnswer(String.format("%d,%d", 
            parser().getCoords().get(i).x(),
            parser().getCoords().get(i).y()
        ));

    }

    private void print(MazeGenerator generator)
    {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < getParamInt("height"); row++) {
            for (int col = 0; col < getParamInt("width"); col++)
                if (generator.isWall(Coordinates.fromInteger(col, row)))
                    sb.append("#");
                else
                    sb.append(".");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
