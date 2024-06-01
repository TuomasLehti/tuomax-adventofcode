package fi.tuomax.adventofcode.framework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * <p>Manufactures input for Advent of Code puzzles from different sources.</p>
 * 
 * <p>Every AoC puzzle comes with its own input. This factory class 
 * standardizes things so that the inputs can be read from local computer, over
 * the Internet and what have you.</p>
 * 
 * <p>Every input I've seen so far has been text, which is why I've chosen to
 * represent the input as a list of strings.</p>
 */
public class InputFactory 
{

    /**
     * Reads input from a file.
     */
    public static List<String> inputFromFile(File file) 
    throws IOException
    {
        return Files.readAllLines(file.toPath());
    }

    /**
     * Reads input from a while which is located outside this repository.
     * The file name is constructed using the metadata associated with the 
     * puzzle.
     */
    public static List<String> inputFromMetadata(Metadata metadata, String filename) 
    throws IOException
    {
        String path = String.format(
            "inputs/y%d/d%02d/%d-%02d %s",
            metadata.year(), metadata.day(),
            metadata.year(), metadata.day(),
            filename
        );
        return InputFactory.inputFromFile(new File(path));
    }
    
}
