package fi.tuomax.adventofcode.year2022.day20;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Test_GpsMixer {

    @Test
    public void test_Num_Equality()
    {
        GpsNumber one = manufactureNumber(1, 1, 1);
        GpsNumber other = manufactureNumber(1, 1, 1);
        assertEquals(one, other);

        GpsNumber mixed = manufactureNumber(1, 1, 9);
        assertEquals(one, other);
    }

    private GpsNumber manufactureNumber(int num, int origIdx, int currIdx)
    {
        GpsNumber n = new GpsNumber();
        n.num = num;
        n.origIdx = origIdx;
        n.currIdx = currIdx;
        return n;
    }

    @Test
    public void test_GetMixed()
    {
        GpsMixer one = manufactureMixer(new int[]{0, 1, 2, 3});
        assertEquals(0, one.getMixed(-4).num);
        assertEquals(1, one.getMixed(-3).num);
        assertEquals(2, one.getMixed(-2).num);
        assertEquals(3, one.getMixed(-1).num);
        assertEquals(0, one.getMixed(0).num);
        assertEquals(1, one.getMixed(1).num);
        assertEquals(2, one.getMixed(2).num);
        assertEquals(3, one.getMixed(3).num);
        assertEquals(0, one.getMixed(4).num);
        assertEquals(1, one.getMixed(5).num);
        assertEquals(2, one.getMixed(6).num);
        assertEquals(3, one.getMixed(7).num);
    }

    @Test
    public void test_Equality()
    {
        GpsMixer one = manufactureMixer(new int[]{0, 1, 2, 3});
        GpsMixer other = manufactureMixer(new int[]{0, 1, 2, 3});
        assertEquals(one, other);
        assertEquals(other, one);
    }

    @Test
    public void test_Equality_Offset()
    {
        GpsMixer one = manufactureMixer(new int[]{0, 1, 2, 3});
        GpsMixer offset = manufactureMixer(new int[]{2, 3, 0, 1});
        assertEquals(one, offset);
        assertEquals(offset, one);
    }

    @Test
    public void test_Unequality()
    {
        GpsMixer one = manufactureMixer(new int[]{0, 1, 2, 3});
        GpsMixer opposite = manufactureMixer(new int[]{3, 2, 1, 0});
        assertNotEquals(one, opposite);
        assertNotEquals(opposite, one);
    }

    @Test
    public void test_Move()
    {
        GpsMixer one = manufactureMixer(new int[]{0, 1, 2, 3, 4});
        one.move(1, 3);
        GpsMixer expected = manufactureMixer(new int[]{0, 2, 3, 1, 4});
        assertEquals(expected, one);
    }

    @Test
    public void test_Move_ToLast()
    {
        GpsMixer one = manufactureMixer(new int[]{0, 1, 2, 3, 4});
        one.move(1, 4);
        GpsMixer expected = manufactureMixer(new int[]{0, 2, 3, 4, 1});
        assertEquals(expected, one);
    }

    @Test
    public void test_MoveLeft()
    {
        GpsMixer one = manufactureMixer(new int[]{0, 1, 2, 3, 4});
        one.move(3, 1);
        GpsMixer expected = manufactureMixer(new int[]{0, 1, 3, 2, 4});
        assertEquals(expected, one);
    }

    @Test
    public void test_MoveLeft_ToFirst()
    {
        GpsMixer one = manufactureMixer(new int[]{0, 1, 2, 3, 4});
        one.move(3, -1);
        GpsMixer expected = manufactureMixer(new int[]{3, 0, 1, 2, 4});
        assertEquals(expected, one);
    }

    @Test
    public void test_MoveByNum()
    {
        GpsMixer original = manufactureMixer(new int[]{0, 10, 11, 1, 12, 13});
        GpsMixer expected = manufactureMixer(new int[]{0, 10, 11, 12, 1, 13});
        original.moveByNum(3);
        assertEquals(expected, original);
    }

    @Test
    public void test_MoveByNum_ToLast()
    {
        GpsMixer original = manufactureMixer(new int[]{0, 10, 11, 2, 12, 13});
        GpsMixer expected = manufactureMixer(new int[]{0, 10, 11, 12, 13, 2});
        original.moveByNum(3);
        assertEquals(expected, original);
    }

    @Test
    public void test_MoveByNum_WrapAround()
    {
        GpsMixer original = manufactureMixer(new int[]{0, 10, 11, 4, 12, 13});
        GpsMixer expected = manufactureMixer(new int[]{0, 10, 4, 11, 12, 13});
        original.moveByNum(3);
        assertEquals(expected, original);
    }

    @Test
    public void test_MoveByNum_Left()
    {
        GpsMixer original = manufactureMixer(new int[]{0, 10, 11, -1, 12, 13});
        GpsMixer expected = manufactureMixer(new int[]{0, 10, -1, 11, 12, 13});
        original.moveByNum(3);
        assertEquals(expected, original);
    }

    @Test
    public void test_MoveByNum_Left_ToFirst()
    {
        GpsMixer original = manufactureMixer(new int[]{0, 10, 11, -3, 12, 13});
        GpsMixer expected = manufactureMixer(new int[]{-3, 0, 10, 11, 12, 13});
        original.moveByNum(3);
        assertEquals(expected, original);
    }

    @Test
    public void test_MoveByNum_Left_WrapAround()
    {
        GpsMixer original = manufactureMixer(new int[]{0, 10, 11, -4, 12, 13});
        GpsMixer expected = manufactureMixer(new int[]{0, 10, 11, 12, -4, 13});
        original.moveByNum(3);
        assertEquals(expected, original);
    }
    
    private GpsMixer manufactureMixer(int[] nums)
    {
        GpsMixer mixer = new GpsMixer();
        for (int num : nums)
            mixer.addInteger(num);
        return mixer;
    }

}
