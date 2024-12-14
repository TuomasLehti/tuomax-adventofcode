package fi.tuomax.adventofcode.year2024.day14;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2024, day 14, part 1:
 * Restroom Redoubt.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/14">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RestroomRedoubt_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 14, 1,
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

        List<Robot> robots = ((RestroomRedoubt_Parser) parser).getRobots();
        for (Robot robot : robots)
            robot.step(100);

        Coordinates middle = Coordinates.fromInteger(
            Robot.spaceWidth / 2, 
            Robot.spaceHeight / 2
        );

        Map<Integer, Integer> numOfRobots = new HashMap<>();
        for (Robot robot : robots) {
            if (
                robot.getPosition().x().equals(middle.x()) ||
                robot.getPosition().y().equals(middle.y()) 
            ) continue;
            Integer quadX = robot.getPosition().x() < middle.x() ? 0 : 1;
            Integer quadY = robot.getPosition().y() < middle.y() ? 0 : 1;
            Integer quad = quadY * 2 + quadX;
            numOfRobots.put(quad, numOfRobots.getOrDefault(quad, Integer.valueOf(0)) + 1);
        }

        setAnswer(
            numOfRobots.get(0) * 
            numOfRobots.get(1) * 
            numOfRobots.get(2) * 
            numOfRobots.get(3));
    }

}
