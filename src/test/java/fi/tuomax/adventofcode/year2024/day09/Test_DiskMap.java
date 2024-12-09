package fi.tuomax.adventofcode.year2024.day09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Test_DiskMap 
{

    @Test
    public void test_Add_And_ToString()
    {
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0, 5));
        dm.addHistoriansFile(new HistoriansFile(1, 9, 5));
        dm.addHistoriansFile(new HistoriansFile(2, 19, 5));
        dm.addHistoriansFile(new HistoriansFile(3, 24, 2));
        assertEquals("00000....11111.....2222233", dm.toString());
    }

    @Test
    public void test_GapSizeAfter()
    {
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0, 1));
        dm.addHistoriansFile(new HistoriansFile(1, 3, 1));
        assertEquals(2, (int) dm.gapSizeAfter(0));
        assertEquals(0, (int) dm.gapSizeAfter(1));
    }

    @Test
    public void test_GapSizeAfterOfZero()
    {
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0, 1));
        dm.addHistoriansFile(new HistoriansFile(1, 1, 1));
        assertEquals(0, (int) dm.gapSizeAfter(0));
        assertEquals(0, (int) dm.gapSizeAfter(1));
    }

    @Test
    public void test_IsNotContiguous()
    {
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0, 5));
        dm.addHistoriansFile(new HistoriansFile(1, 9, 5));
        dm.addHistoriansFile(new HistoriansFile(2, 19, 5));
        dm.addHistoriansFile(new HistoriansFile(3, 24, 2));
        assertFalse(dm.isContiguous());
    }

    @Test
    public void test_IsContiguous()
    {
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0, 5));
        dm.addHistoriansFile(new HistoriansFile(1, 5, 5));
        dm.addHistoriansFile(new HistoriansFile(2, 10, 5));
        assertTrue(dm.isContiguous());
    }

    @Test
    public void test_Move()
    {
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0, 2));
        dm.addHistoriansFile(new HistoriansFile(1, 4, 2));
        dm.addHistoriansFile(new HistoriansFile(2, 6, 2));
        assertEquals("00..1122", dm.toString());
        dm.move();
        assertEquals("002211", dm.toString());
    }

    @Test
    public void test_Move_FileBiggerThanGap()
    {
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0, 2));
        dm.addHistoriansFile(new HistoriansFile(1, 4, 2));
        dm.addHistoriansFile(new HistoriansFile(2, 6, 5));
        assertEquals("00..1122222", dm.toString());
        dm.move();
        assertEquals("002211222", dm.toString());
    }

    @Test
    public void test_Fragment()
    {
        // 0..111....22222
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0, 1));
        dm.addHistoriansFile(new HistoriansFile(1, 3, 3));
        dm.addHistoriansFile(new HistoriansFile(2, 10, 5));
        assertEquals("0..111....22222", dm.toString());
        dm.fragment();
        assertEquals("022111222", dm.toString());
    }
    
}
