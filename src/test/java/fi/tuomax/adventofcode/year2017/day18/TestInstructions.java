package fi.tuomax.adventofcode.year2017.day18;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.cpu.Cpu;

public class TestInstructions 
{

    @Test
    public void test_Snd()
    {
        Set<String> regs = new HashSet<>();
        regs.add("a");
        Cpu cpu = new Cpu(regs);
        Duet_Snd snd = new Duet_Snd("snd 42", cpu);

        assertEquals(0, (int) Duet_Snd.lastPlayed);
        snd.run(cpu);
        assertEquals(42, (int) Duet_Snd.lastPlayed);
    }

}
