package fi.tuomax.adventofcode.commons.cpu;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Test_Cpu 
{

    @Test
    public void test_Run()
    {
        Set<String> registers = new HashSet<>();
        registers.add("A");
        Cpu cpu = new Cpu(registers);
        cpu.enterProgram(new Nop("", cpu));
        cpu.run();
        assertEquals(1, (int) cpu.getProgramCounter());
    }

    private class Nop 
    extends Instruction 
    {
        public Nop(String input, Cpu cpu) {
            super(input, cpu);
        }

        @Override
        public void run(Cpu cpu) {
        }

        @Override
        public Instruction toggle() {
            return this;
        }

    }
    
}
