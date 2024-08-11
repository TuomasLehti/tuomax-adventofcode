package fi.tuomax.adventofcode.year2016.day16;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;

public class Test_DragonChecksum 
extends PuzzleTester
{

    @Test
    public void test_Part1()
    {
        try {
            DragonChecksum_Part1 part = new DragonChecksum_Part1();
            part.setParameters(fetchJson(part.getMetadata(), "test parameters.json"));
            part.run(InputFactory.inputFromMetadata(part.getMetadata(), "test.txt"));
            assertEquals("01100", part.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
