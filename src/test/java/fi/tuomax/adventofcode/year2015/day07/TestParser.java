package fi.tuomax.adventofcode.year2015.day07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TestParser 
{

    @Test
    public void test()
    {
        try {
            SomeAssemblyRequired_Parser parser = new SomeAssemblyRequired_Parser(
                InputFactory.inputFromMetadata(
                    new Metadata(2015, 7, null, null, null), 
                    "test.txt"
                )
            );
            parser.parse();
            HashMap<String, Gate> gates = parser.getGates();
            
            assertEquals(72, (int) gates.get("d").getOutputSignal(gates));
            assertEquals(507, (int) gates.get("e").getOutputSignal(gates));
            assertEquals(492, (int) gates.get("f").getOutputSignal(gates));
            assertEquals(114, (int) gates.get("g").getOutputSignal(gates));
            assertEquals(65412, (int) gates.get("h").getOutputSignal(gates));
            assertEquals(65079, (int) gates.get("i").getOutputSignal(gates));
            assertEquals(123, (int) gates.get("x").getOutputSignal(gates));
            assertEquals(456, (int) gates.get("y").getOutputSignal(gates));

        } catch (IOException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }
    
}
