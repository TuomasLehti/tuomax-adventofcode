package fi.tuomax.adventofcode.framework.inputting;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Manufactures input for Advent of Code puzzles from different sources.</p>
 * 
 * <p>Every AoC puzzle comes with its own input. This factory class 
 * standardizes things so that the inputs can be read from local computer, over
 * the Internet and what have you.</p>
 * 
 * <p>Every input I've seen so far has been text, which is why I've chosen to
 * represent the input as a list of strings.</p>
 
 * <p>Please note the restrictions on distributing the puzzle input. Inputs
 * should not be distributed at all, and I've taken this to mean the example 
 * inputs from the puzzle description as well. Therefore even the single line
 * inputs should be abstracted away from repositories.</p>
 */
public class InputFactory 
{

    public static final String DEFAULT_INPUT_FILENAME = "input.txt";

    public static List<String> inputFromFile(File file) 
    throws IOException
    {
        return Files.readAllLines(file.toPath());
    }

    public static List<String> inputFromString(String string)
    {
        return Arrays.asList(string.split("\n"));
    }

    /**
     * Reads input from a while which is located outside this repository.
     * The file name is constructed using the metadata associated with the 
     * puzzle.
     */
    public static List<String> inputFromMetadata(Metadata metadata, String filename) 
    throws IOException
    {
        return InputFactory.inputFromFile(
            new File(InputFactory.inputLocation(metadata, filename))
        );
    }

    public static String inputLocation(Metadata metadata, String filename)
    {
        return String.format(
            "inputs/y%d/d%02d/%d-%02d %s",
            metadata.year(), metadata.day(),
            metadata.year(), metadata.day(),
            filename
        );
    }
    
}
