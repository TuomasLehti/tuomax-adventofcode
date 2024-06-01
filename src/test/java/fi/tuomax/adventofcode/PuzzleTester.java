package fi.tuomax.adventofcode;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.URL;

/**
 * Includes helpers for testing. This class should be inherited by all other
 * test classes.
 */
public class PuzzleTester 
{

    public File fetchResource(String filename)
    {
        URL url = getClass().getResource(filename);
        assertNotNull(url);
        return new File(url.getPath().substring(1));
    }
    
}
