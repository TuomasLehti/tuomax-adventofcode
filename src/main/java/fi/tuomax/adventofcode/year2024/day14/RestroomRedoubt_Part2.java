package fi.tuomax.adventofcode.year2024.day14;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2024, day 14, part 2:
 * Restroom Redoubt.</p>
 * 
 * 
 * 
 * <p>Getting the solution through visualization:</p>
 * 
 * <p>While visualizing the position of the robots something caught my eye.
 * Every so often the grid almost seemed to organize to an image of an easter
 * bunny with a vertical line on top and bottom.</p>
 * 
 * <p>There were also steps in which the robots are clumped together 
 * horizontally and form vertical lines. I was more intrested in the bunnies,
 * however.</p>
 * 
 * <p>It turned out that the number of steps between almost-bunnies was 
 * constant. I quickly sifted through the steps in question and found the 
 * answer.</p>
 * 
 * <p>I wasn't satisfied by this visual method, however. I wanted the computer
 * to find the tree, so I set to come up with an algorithm which would do just
 * that.</p>
 * 
 * 
 * 
 * <p>Insight 1: The movement of robots is cyclical.</p>
 * 
 * <p>Consider a grid of size (11, 7) as in the example given in the AoC 
 * puzzle, and a robot, which moves one step down in one second. It returns
 * to its starting position after 7 seconds.</p>
 * 
 * <p>Another robot which moves two steps down and one step right per second, 
 * moves through the coordinate space like so: (0, 0) -> (1, 2) -> (2, 4) ->
 * (3, 6) -> (4, 1) -> (5, 3) -> (6, 5) -> (7, 0).</p>
 * 
 * <p>In other words, the other robot has moved one step right in 7 seconds.
 * It follows, that in another 7 seconds (14 seconds total) it must have moved 
 * another step to the right, and so on. The whole cycle looks like this:</p>
 * 
 * <ul>
 * <li>time = 0, position = (0, 0)
 * <li>time = 7, position = (1, 0)
 * <li>time = 14, position = (2, 0)
 * <li>time = 21, position = (3, 0)
 * <li>time = 28, position = (4, 0)
 * <li>time = 35, position = (5, 0)
 * <li>time = 42, position = (6, 0)
 * <li>time = 49, position = (7, 0)
 * <li>time = 56, position = (8, 0)
 * <li>time = 63, position = (9, 0)
 * <li>time = 70, position = (10, 0)
 * <li>time = 77, position = (0, 0)
 * </ul>
 * 
 * <p>The other robot has returned to its starting location after 77 seconds.
 * 77 is also the product of the width and the height of our grid size!</p>
 * 
 * <p>The grid size is (103, 100), which yields 10300 states. It should be
 * feasible to do some statistical analysis on an input of that size.</p>
 * 
 * 
 * 
 * <p>Insight 2: Differentiating between random noise and an image.</p>
 * 
 * <p>As I'd already seen the tree, I knew there was a box around it, and the
 * shape of the tree was filled. This meant that the step in question would 
 * have a lot of robots in a tight formation.</p>
 * 
 * <p>The easiest way to find areas of high robot concentartion was to inspect
 * each row and column of the grid step by step. I exported the number of
 * robots per row and column per step to a file and studied the data in a
 * spreadsheet program.</p>
 * 
 * <p>The bunny-steps yielded high values for amounts of robots in rows, but 
 * the values for amounts of robots in columns were comparable to random 
 * noise.</p>
 * 
 * <p>On the other hand, the steps in which the vertical lines naturally
 * yielded high values for amounts of robots in columns, and random noise
 * for the amounts of robots in rows.</p>
 * 
 * <p>There's only one step in which the number of robots in rows and columns
 * are both high, and that is the target step.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/14">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RestroomRedoubt_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 14, 2,
            "Restroom Redoubt", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new RestroomRedoubt_Parser(input);
    }

    @Override
    protected void solve()
    {
        Robot.spaceWidth = getParamInt("width");
        Robot.spaceHeight = getParamInt("height");
        int size = Robot.spaceWidth * Robot.spaceHeight;
        List<Robot> robots = ((RestroomRedoubt_Parser) parser).getRobots();

        /* Collect the positions of every robot after every step. */
        List<List<Coordinates>> positionss = calculatePositionss(robots);

        /** Collect the number of robots per row after each step. */
        List<List<Integer>> robotsPerRow = calculateRobotsPerRow(positionss);

        /** Collect the number of robots per column after each step. */
        List<List<Integer>> robotsPerCol = calculateRobotsPerCol(positionss);

        /* Find the step which has rows and columns of over 30 robots. */
        LoggerFactory.getLogger(getClass()).debug("Searching for the tree in a box...");
        for (int step = 0; step < size; step++) {
            if (
                isOverThreshold(robotsPerCol.get(step), 30) &&
                isOverThreshold(robotsPerRow.get(step), 30)
            ) {
                setAnswer(step);
            }
        }
    }

    private List<List<Coordinates>> calculatePositionss(List<Robot> robots)
    {
        LoggerFactory.getLogger(getClass()).debug("Calculating positions...");
        int size = Robot.spaceWidth * Robot.spaceHeight;
        List<List<Coordinates>> allPositions = new ArrayList<>();
        for (int step = 0; step <= size; step++) {
            List<Coordinates> positions = new ArrayList<>();
            for (Robot robot : robots)
                positions.add(robot.getPosition());
            allPositions.add(positions);

            for (Robot robot : robots)
                robot.step(1);
        }
        return allPositions;
    }

    private List<List<Integer>> calculateRobotsPerRow(List<List<Coordinates>> positionss)
    {
        LoggerFactory.getLogger(getClass()).debug("Calculating robots per row...");
        List<List<Integer>> rpr = new ArrayList<>();
        for (List<Coordinates> positions : positionss)
            rpr.add(robotsPerRow(positions));
        return rpr;
    }

    private List<List<Integer>> calculateRobotsPerCol(List<List<Coordinates>> positionss)
    {
        LoggerFactory.getLogger(getClass()).debug("Calculating robots per column...");
        List<List<Integer>> rpc = new ArrayList<>();
        for (List<Coordinates> positions : positionss)
            rpc.add(robotsPerCol(positions));
        return rpc;
    }

    private Boolean isOverThreshold(List<Integer> positions, Integer threshold)
    {
        for (Integer i : positions)
            if (i > threshold)
                return true;
        return false;
    }

    /** Outputs the number of robots per row for each step to a file. 
     *  Kept in codebase because it is referenced in the write-up. */
    @SuppressWarnings("unused")
    private void robotsPerRowToCsv(String filename, List<List<Coordinates>> poss)
    {
        List<String> strings = new ArrayList<>();
        int step = 0;
        for (List<Coordinates> pos : poss) {
            strings.add(String.format(
                "%d,%s", 
                step, 
                intListToString(robotsPerRow(pos))
            ));
            step++;
        }
        File file = new File(filename);
        try {
            Files.write(file.toPath(), strings);
        } catch (IOException e) {
            LoggerFactory.getLogger(getClass()).error("Wasn't able to write.");

        }
    }

    private String intListToString(List<Integer> intList)
    {
        StringBuilder sb = new StringBuilder();
        for (Integer i : intList) {
            if (sb.length() > 0) sb.append(",");
            sb.append(i.toString());
        }
        return sb.toString();
    }

    private List<Integer> robotsPerRow(List<Coordinates> poss)
    {
        Map<Integer, Integer> rplMap = new HashMap<>();
        for (Coordinates pos : poss) {
            Integer y = pos.yAsInt();
            rplMap.put(y, rplMap.getOrDefault(y, 0) + 1);
        }
        List<Integer> rplList = new ArrayList<>();
        for (int row = 0; row < Robot.spaceHeight; row++)
            rplList.add(rplMap.getOrDefault(row, 0));
        return rplList;
    }

    private List<Integer> robotsPerCol(List<Coordinates> poss)
    {
        Map<Integer, Integer> rpcMap = new HashMap<>();
        for (Coordinates pos : poss) {
            Integer x = pos.xAsInt();
            rpcMap.put(x, rpcMap.getOrDefault(x, 0) + 1);
        }
        List<Integer> rplList = new ArrayList<>();
        for (int row = 0; row < Robot.spaceHeight; row++)
            rplList.add(rpcMap.getOrDefault(row, 0));
        return rplList;

    }

    /** Prints a step into the console.
     *  Kept in codebase because it is referenced in the write-up. */
    @SuppressWarnings("unused")
    private void print(List<Robot> robots)
    {
        StringBuilder sb = new StringBuilder("\n\n");
        for (int row = 0; row < Robot.spaceHeight; row++) {
            colLoop: for (int col = 0; col < Robot.spaceWidth; col++) {
                Coordinates c = Coordinates.fromInteger(col, row);
                for (Robot robot : robots) 
                    if (robot.getPosition().equals(c)) {
                        sb.append("X");
                        continue colLoop;
                    }
                sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
