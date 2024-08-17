package fi.tuomax.adventofcode.year2016.day19;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_Elf 
{

    @Test
    public void test_Create()
    {
        Elf.create(5);

        Elf elf = Elf.head;
        for (int i = 1; i < 5; i++) {
            assertEquals(i, elf.num);
            elf = elf.left;
        }
        assertEquals(5, elf.num);
        assertEquals(1, elf.left.num);
    }
    
}
