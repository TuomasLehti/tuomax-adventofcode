package fi.tuomax.adventofcode.year2024.day09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_DiskMap 
{

    @Test
    public void test_Add_And_ToString()
    {
        DiskMap dm = new DiskMap();
        dm.addHistoriansFile(new HistoriansFile(0, 0L, 5));
        dm.addHistoriansFile(new HistoriansFile(1, 9L, 5));
        dm.addHistoriansFile(new HistoriansFile(2, 19L, 5));
        dm.addHistoriansFile(new HistoriansFile(3, 24L, 2));
        assertEquals("00000....11111.....2222233", dm.toString());
    }
    
}
