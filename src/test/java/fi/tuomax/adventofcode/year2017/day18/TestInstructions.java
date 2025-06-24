package fi.tuomax.adventofcode.year2017.day18;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;

public class TestInstructions 
{

    @Test
    public void test_Snd()
    {
        Set<String> regs = new HashSet<>();
        regs.add("a");
        Cpu cpu = new Cpu(regs);
        Duet_Snd snd = new Duet_Snd(cpu, new Argument(cpu, "42"));

        assertEquals(0L, (long) Duet_Snd.lastPlayed);
        snd.run();
        assertEquals(42L, (long) Duet_Snd.lastPlayed);
    }

}
