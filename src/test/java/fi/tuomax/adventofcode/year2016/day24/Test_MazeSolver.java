package fi.tuomax.adventofcode.year2016.day24;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.pathfinding.MazeSolver;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_MazeSolver 
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
            MazeSolver ms = new MazeSolver(parser.getMaze());
            assertEquals(2, (int) ms.pathLength(new Coordinates(1L, 1L), new Coordinates(3L, 1L)));
            assertEquals(4, (int) ms.pathLength(new Coordinates(1L, 3L), new Coordinates(3L, 1L)));
        } catch (IOException e) {
            fail(e.getMessage());
        }

    }
    
}
