package fi.tuomax.adventofcode.year2022.day09;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Solves Advent of Code 2022, day 9, part 1:
 * Rope Bridge.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/9">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RopeBridge_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 9, 1,
            "Rope Bridge", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new RopeBridge_Parser(input);
    }

    private Boolean dblEq(Double d1, Double d2)
    {
        final Double PRECISION = 0.01;
        return (Math.abs(d1 - d2) < PRECISION);
    }

    @Override
    protected void solve()
    {
        Coordinates head = Coordinates.ORIGIN;
        Coordinates tail = Coordinates.ORIGIN;

        Set<Coordinates> visited = new HashSet<>();

        List<Motion> motions = ((RopeBridge_Parser) parser).getMotions();
        for (Motion motion : motions) {
            for (int i = 0; i < motion.amount(); i++) {
                visited.add(tail);
//                print(head, tail);

                head = head.translate(motion.direction().asCoordinates());
                Double xDist = (double) head.x() - tail.x();
                Double yDist = (double) head.y() - tail.y();
                Double dist = Math.sqrt(xDist * xDist + yDist * yDist);
                if (dist < 2) continue;
                if (dblEq(dist, 2.0)) {
                    tail = tail.translate(motion.direction().asCoordinates());
                    continue;
                }

                //..H
                //...
                //T..
                if (head.x() > tail.x() && head.y() > tail.y())
                    tail = tail.translate(Direction.getInstance(Direction.NORTHEAST).asCoordinates());
                //H..
                //...
                //..T
                else if (head.x() < tail.x() && head.y() > tail.y())
                    tail = tail.translate(Direction.getInstance(Direction.NORTHWEST).asCoordinates());
                //..T
                //...
                //H..
                else if (head.x() < tail.x() && head.y() < tail.y())
                    tail = tail.translate(Direction.getInstance(Direction.SOUTHWEST).asCoordinates());
                //T..
                //...
                //..H
                else if (head.x() > tail.x() && head.y() < tail.y())
                    tail = tail.translate(Direction.getInstance(Direction.SOUTHEAST).asCoordinates());
          }
        }
        visited.add(tail);
        setAnswer(visited.size());
    }

    private void print(Coordinates head, Coordinates tail)
    {
        System.out.println();
        StringBuilder sb = new StringBuilder();
        for (long y = 0; y < 10; y++) {
            sb.append(y);
            sb.append(" ");
            for (long x = 0; x < 10; x++) {
                if (head.x().equals(x) && head.y().equals(y))
                    sb.append("H");
                else if (tail.x().equals(x) && tail.y().equals(y))
                    sb.append("T");
                else
                    sb.append(".");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
