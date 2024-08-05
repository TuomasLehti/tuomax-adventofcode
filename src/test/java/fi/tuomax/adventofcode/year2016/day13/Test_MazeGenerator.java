package fi.tuomax.adventofcode.year2016.day13;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Test_MazeGenerator 
{

    @Test
    public void test()
    {
        MazeGenerator.favoriteNumber = 10;
        assertTrue(MazeGenerator.isWall(1, 0));
        assertTrue(MazeGenerator.isWall(3, 0));
        assertTrue(MazeGenerator.isWall(4, 0));
        assertTrue(MazeGenerator.isWall(5, 0));
        assertTrue(MazeGenerator.isWall(6, 0));
        assertTrue(MazeGenerator.isWall(8, 0));
        assertTrue(MazeGenerator.isWall(9, 0));
        assertTrue(MazeGenerator.isWall(0, 2));
        assertTrue(MazeGenerator.isWall(5, 2));
        assertTrue(MazeGenerator.isWall(6, 2));

        assertFalse(MazeGenerator.isWall(3, 3));
        assertFalse(MazeGenerator.isWall(5, 3));
        assertFalse(MazeGenerator.isWall(9, 3));
        assertFalse(MazeGenerator.isWall(1, 6));
        assertFalse(MazeGenerator.isWall(2, 6));
        assertFalse(MazeGenerator.isWall(3, 6));
        assertFalse(MazeGenerator.isWall(6, 6));
        
    }
    
}
