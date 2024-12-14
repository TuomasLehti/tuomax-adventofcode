package fi.tuomax.adventofcode.year2024.day14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void test_Robot_Step()
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
    public void test_Robot_IsMirrorOf_DifferentRows()
    {
        Robot.spaceWidth = 5;
        Robot.spaceHeight = 5;
        Robot one = new Robot("p=3,0 v=2,-3");
        Robot other = new  Robot("p=1,3 v=2,-3");
        assertFalse(one.isMirrorOf(other));
    }

    @Test
    public void test_Robot_IsMirrorOf_InMiddle()
    {
        Robot.spaceWidth = 5;
        Robot.spaceHeight = 5;
        Robot one = new Robot("p=2,0 v=2,-3");
        Robot other = new  Robot("p=1,0 v=2,-3");
        assertTrue(one.isMirrorOf(other));
    }

    @Test
    public void test_Robot_IsMirrorOf_DifferentDistances()
    {
        Robot.spaceWidth = 5;
        Robot.spaceHeight = 5;
        Robot one = new Robot("p=4,0 v=2,-3");
        Robot other = new  Robot("p=1,0 v=2,-3");
        assertFalse(one.isMirrorOf(other));
    }

    @Test
    public void test_Robot_IsMirrorOf_Yes()
    {
        Robot.spaceWidth = 5;
        Robot.spaceHeight = 5;
        Robot one = new Robot("p=3,0 v=2,-3");
        Robot other = new  Robot("p=1,0 v=2,-3");
        assertTrue(one.isMirrorOf(other));
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
