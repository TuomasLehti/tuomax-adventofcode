package fi.tuomax.adventofcode.year2022.day09;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Solves Advent of Code 2022, day 9, part 2:
 * Rope Bridge.</p>
 * 
 * @todo: Clean and refactor, combine with part 1
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/9">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RopeBridge_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 9, 2,
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

    /**
     * Polar coordinates radial. (Distance from origin to a point.)
     */
    private Double pcRadial(Coordinates c)
    {
        return Math.sqrt(c.x() * c.x() + c.y() * c.y());
    }

    /**
     * Polar coordinates angle.
     */
    private Double pcAngular(Coordinates c)
    {
        Double atan = Math.atan2(c.y(), c.x());
        if (atan < 0) atan += Math.PI * 2;
        return atan;
    }

    private Coordinates follow(Coordinates head, Coordinates tail)
    throws IllegalStateException
    {
        final Coordinates EAST = Direction.getInstance(Direction.EAST).asCoordinates();
        final Coordinates NORTHEAST = Direction.getInstance(Direction.NORTHEAST).asCoordinates();
        final Coordinates NORTH = Direction.getInstance(Direction.NORTH).asCoordinates();
        final Coordinates NORTHWEST = Direction.getInstance(Direction.NORTHWEST).asCoordinates();
        final Coordinates WEST = Direction.getInstance(Direction.WEST).asCoordinates();
        final Coordinates SOUTHWEST = Direction.getInstance(Direction.SOUTHWEST).asCoordinates();
        final Coordinates SOUTH = Direction.getInstance(Direction.SOUTH).asCoordinates();
        final Coordinates SOUTHEAST = Direction.getInstance(Direction.SOUTHEAST).asCoordinates();

        final Double E = pcAngular(new Coordinates(1L, 0L));
        final Double ENE = pcAngular(new Coordinates(2L, 1L));
        final Double NE = pcAngular(new Coordinates(1L, 1L));
        final Double NNE = pcAngular(new Coordinates(1L, 2L));

        final Double N = pcAngular(new Coordinates(0L, 1L));
        final Double NNW = pcAngular(new Coordinates(-1L, 2L));
        final Double NW = pcAngular(new Coordinates(-1L, 1L));
        final Double WNW = pcAngular(new Coordinates(-2L, 1L));

        final Double W = pcAngular(new Coordinates(-1L, 0L));
        final Double WSW = pcAngular(new Coordinates(-2L, -1L));
        final Double SW = pcAngular(new Coordinates(-1L, -1L));
        final Double SSW = pcAngular(new Coordinates(-1L, -2L));

        final Double S = pcAngular(new Coordinates(0L, -1L));
        final Double SSE = pcAngular(new Coordinates(1L, -2L));
        final Double SE = pcAngular(new Coordinates(1L, -1L));
        final Double ESE = pcAngular(new Coordinates(2L, -1L));

        Coordinates liat = new Coordinates(tail.x() * -1, tail.y() * -1);
        Double dist = pcRadial(head.translate(liat));
        Double angle = pcAngular(head.translate(liat));

        if (dist < 2) return tail;
        if (dblEq(E, angle)) return tail.translate(EAST);
        if (dblEq(NE, angle)) return tail.translate(NORTHEAST);
        if (dblEq(N, angle)) return tail.translate(NORTH);
        if (dblEq(NW, angle)) return tail.translate(NORTHWEST);
        if (dblEq(W, angle)) return tail.translate(WEST);
        if (dblEq(SW, angle)) return tail.translate(SOUTHWEST);
        if (dblEq(S, angle)) return tail.translate(SOUTH);
        if (dblEq(SE, angle)) return tail.translate(SOUTHEAST);
        if (dblEq(ENE, angle)) return tail.translate(NORTHEAST);
        if (dblEq(NNE, angle)) return tail.translate(NORTHEAST);
        if (dblEq(NNW, angle)) return tail.translate(NORTHWEST);
        if (dblEq(WNW, angle)) return tail.translate(NORTHWEST);
        if (dblEq(WSW, angle)) return tail.translate(SOUTHWEST);
        if (dblEq(SSW, angle)) return tail.translate(SOUTHWEST);
        if (dblEq(SSE, angle)) return tail.translate(SOUTHEAST);
        if (dblEq(ESE, angle)) return tail.translate(SOUTHEAST);

        throw new IllegalStateException("panic");
    }

    @Override
    protected void solve()
    {
        Integer ropeLength = getParamInt("rope_length");
        Coordinates[] rope = new Coordinates[ropeLength];
        Arrays.fill(rope, Coordinates.ORIGIN);
        Set<Coordinates> visited = new HashSet<>();
        List<Motion> motions = ((RopeBridge_Parser) parser).getMotions();

        int motionIdx = 1;
        for (Motion motion : motions) {
            for (int i = 0; i < motion.amount(); i++) {
//                print(rope);
                visited.add(rope[ropeLength - 1]);
                rope[0] = rope[0].translate(motion.direction().asCoordinates());
                for (int ropeIdx = 1; ropeIdx < ropeLength; ropeIdx++) {
                    try {
                        rope[ropeIdx] = follow(rope[ropeIdx - 1], rope[ropeIdx]);
                    } catch (IllegalStateException e) {
//                        print(rope);
                        System.out.print("");
                    }
                }
            }
            motionIdx++;
        }
        visited.add(rope[ropeLength - 1]);
        setAnswer(visited.size());
    }

    private void print(Coordinates[] rope)
    {
        int w = 41;
        int h = 41;
        Grid<Character> grid = new Grid<>(w, h);
        for (int r = 0; r < h; r++)
            for (int c = 0; c < w; c++)
                grid.set(c, r, '.');

        char[] chars = "H123456789".toCharArray();
        for (int y = -20; y < 21; y++) 
            for (int x = -20; x < 21; x++) 
                for (int i = 9; i >= 0; i--) 
                    if (rope[i].x().equals((long)x) && rope[i].y().equals((long)y))
                        grid.set(x+20, y+20, Character.valueOf(chars[i]));
        
        StringBuilder sb = new StringBuilder();
        for (int r = h - 1; r >= 0; r--) {
            sb.append(r);
            sb.append(" ");
            for (int c = 0; c < w; c++)
                sb.append(grid.get(c, r));
            sb.append("\n");
        }
                
        System.out.println(sb.toString());
    }

}

