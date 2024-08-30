package fi.tuomax.adventofcode.year2015.day23;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Cpu_Parser;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TestCpu 
{

    @Test
    public void test()
    {
        try {
            Cpu_Parser parser = new Cpu_Parser(
                InputFactory.inputFromMetadata(new Metadata(2015, 23, 1, "", ""), "test.txt"),
                new OpeningTheTuringLock_InstructionFactory()
            );
            parser.parse();
            Cpu cpu = parser.getCpu();
            cpu.run();
            assertEquals(2, (int) cpu.getRegister("a"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    
}
