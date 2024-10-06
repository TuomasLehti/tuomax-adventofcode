package fi.tuomax.adventofcode.year2022.day20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_Nums 
{

    @Test
    public void test_ToString()
    {
        Nums nums = new Nums(new int[]{0, 1, 2, 3, 4, 5, 6});
        assertEquals("0, 1, 2, 3, 4, 5, 6", nums.toString());
    }

    @Test
    public void test_MoveRight()
    {
        Nums nums = new Nums(new int[]{0, 1, 2, 3, 4, 5, 6});
        nums.moveRight(nums.nums.get(1));
        assertEquals("0, 2, 1, 3, 4, 5, 6", nums.toString());
    }

    @Test
    public void test_MoveRight_WrapAround()
    {
        Nums nums = new Nums(new int[]{0, 1, 2, 3, 4, 5, 6});
        nums.moveRight(nums.nums.get(6));
        assertEquals("6, 1, 2, 3, 4, 5, 0", nums.toString());
    }

    @Test
    public void test_MoveLeft()
    {
        Nums nums = new Nums(new int[]{0, 1, 2, 3, 4, 5, 6});
        nums.moveLeft(nums.nums.get(2));
        assertEquals("0, 2, 1, 3, 4, 5, 6", nums.toString());
    }

    @Test
    public void test_MoveLeft_WrapAround()
    {
        Nums nums = new Nums(new int[]{0, 1, 2, 3, 4, 5, 6});
        nums.moveLeft(nums.nums.get(0));
        assertEquals("6, 1, 2, 3, 4, 5, 0", nums.toString());
    }

    @Test
    public void test_Move()
    {
        Nums nums;
        nums = new Nums(new int[]{1, 2, -3, 3, -2, 0, 4});
        nums.move(nums.nums.get(0));
        assertEquals("2, 1, -3, 3, -2, 0, 4", nums.toString());
        nums.move(nums.nums.get(1));
        assertEquals("1, -3, 2, 3, -2, 0, 4", nums.toString());
        nums.move(nums.nums.get(2));
        assertEquals("1, 2, 3, -2, -3, 0, 4", nums.toString());
        nums.move(nums.nums.get(3));
        assertEquals("1, 2, -2, -3, 0, 3, 4", nums.toString());
        nums.move(nums.nums.get(4));
        assertEquals("1, 2, -3, 0, 3, 4, -2", nums.toString());
        nums.move(nums.nums.get(5));
        assertEquals("1, 2, -3, 0, 3, 4, -2", nums.toString());
        nums.move(nums.nums.get(6));
        assertEquals("1, 2, -3, 4, 0, 3, -2", nums.toString());
/*
        Initial arrangement:
        1, 2, -3, 3, -2, 0, 4
        
        1 moves between 2 and -3:
        2, 1, -3, 3, -2, 0, 4
        
        2 moves between -3 and 3:
        1, -3, 2, 3, -2, 0, 4
        
        -3 moves between -2 and 0:
        assertEquals("1, 2, 3, -2, -3, 0, 4", nums.toString());
        
        3 moves between 0 and 4:
        assertEquals("1, 2, -2, -3, 0, 3, 4", nums.toString());
        
        -2 moves between 4 and 1:
        assertEquals("1, 2, -3, 0, 3, 4, -2", nums.toString());
        
        0 does not move:
        assertEquals("1, 2, -3, 0, 3, 4, -2", nums.toString());
        
        4 moves between -3 and 0:
        assertEquals("1, 2, -3, 4, 0, 3, -2", nums.toString());
        */
    }
    
}
