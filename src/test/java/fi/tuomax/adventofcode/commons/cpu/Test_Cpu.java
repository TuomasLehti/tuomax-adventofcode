package fi.tuomax.adventofcode.commons.cpu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_Cpu 
{

    @Test
    public void test_Registers()
    {
        Cpu cpu = new Cpu();
        assertEquals(0L, (long) cpu.getRegister("a"));
        cpu.setRegister("b", 42L);
        assertEquals(42L, (long) cpu.getRegister("b"));
    }

    @Test
    public void test_Run()
    {
        Cpu cpu = new Cpu();
        cpu.enterProgram(new Nop("", cpu));
        cpu.enterProgram(new Nop("", cpu));
        cpu.enterProgram(new Nop("", cpu));
        cpu.run();
        assertEquals(3, (int) cpu.getProgramCounter());
    }

    @Test
    public void test_Step()
    {
        Cpu cpu = new Cpu();
        cpu.enterProgram(new Nop("", cpu));
        cpu.enterProgram(new Nop("", cpu));
        cpu.enterProgram(new Nop("", cpu));
        cpu.step();
        assertEquals(1, (int) cpu.getProgramCounter());
        cpu.step();
        assertEquals(2, (int) cpu.getProgramCounter());
        cpu.step();
        assertEquals(3, (int) cpu.getProgramCounter());
    }
    
}
