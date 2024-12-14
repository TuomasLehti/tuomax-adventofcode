package fi.tuomax.adventofcode.year2024.day14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.commons.Coordinates;

public class Test_RestroomRedoubt
extends PuzzleTester
{

    /** A test to see how the mod operator in Java works. */
    @Test
    public void test_Mod()
    {
        for (int i = 15; i >= -15; i--)
            System.out.println(String.format("%d %% 10 = %d", i, (i + 20) % 10));
    }

    @Test
    public void test_Robot()
    {
        Robot.spaceWidth = 11;
        Robot.spaceHeight = 7;

        Robot robot = new Robot("p=2,4 v=2,-3");
        assertEquals(Coordinates.fromInteger(2, 4), robot.getPosition());

        robot.step(1);
        assertEquals(Coordinates.fromInteger(4, 1), robot.getPosition());
        robot.step(1);
        assertEquals(Coordinates.fromInteger(6, 5), robot.getPosition());
        robot.step(1);
        assertEquals(Coordinates.fromInteger(8, 2), robot.getPosition());
        robot.step(1);
        assertEquals(Coordinates.fromInteger(10, 6), robot.getPosition());
        robot.step(1);
        assertEquals(Coordinates.fromInteger(1, 3), robot.getPosition());
    }

    @Test
    public void test_Part1()
    {
        runTests(new RestroomRedoubt_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new RestroomRedoubt_Part2());
    }

}
