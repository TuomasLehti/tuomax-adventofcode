package fi.tuomax.adventofcode.year2016.day24;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_AirDuctSpelunking_Parser
{

    @Test
    public void test()
    {
        try {
            AirDuctSpelunking_Parser parser = new AirDuctSpelunking_Parser(
                    InputFactory.inputFromMetadata(
                            new Metadata(2016, 24, null, null, null), 
                            "test.txt"));
            parser.parse();
            assertTrue(parser.getTargets().contains(new Coordinates(1L, 1L)));
            assertTrue(parser.getTargets().contains(new Coordinates(3L, 1L)));
            assertTrue(parser.getTargets().contains(new Coordinates(9L, 1L)));
            assertTrue(parser.getTargets().contains(new Coordinates(9L, 3L)));
            assertTrue(parser.getTargets().contains(new Coordinates(1L, 3L)));
            assertTrue(parser.getMaze().isWall(new Coordinates(5L, 2L)));
            assertTrue(parser.getMaze().isWall(new Coordinates(0L, 0L)));
            assertTrue(parser.getMaze().isWall(new Coordinates(10L, 4L)));
            assertFalse(parser.getMaze().isWall(new Coordinates(1L, 1L)));
            assertFalse(parser.getMaze().isWall(new Coordinates(4L, 1L)));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
