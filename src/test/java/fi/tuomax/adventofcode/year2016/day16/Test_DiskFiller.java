package fi.tuomax.adventofcode.year2016.day16;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_DiskFiller 
{

    @Test
    public void test()
    {
        assertEquals("001", DiskFiller.fill("0"));
        assertEquals("100", DiskFiller.fill("1"));
        assertEquals("11111000000", DiskFiller.fill("11111"));
        assertEquals("1111000010100101011110000", DiskFiller.fill("111100001010"));
    }
    
}
