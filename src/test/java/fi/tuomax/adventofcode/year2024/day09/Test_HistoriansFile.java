package fi.tuomax.adventofcode.year2024.day09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_HistoriansFile 
{

    @Test
    public void test_GetEnd()
    {
        HistoriansFile hf = new HistoriansFile(0, 0, 2);
        assertEquals(1, (int) hf.getEnd());
    }
    
}
