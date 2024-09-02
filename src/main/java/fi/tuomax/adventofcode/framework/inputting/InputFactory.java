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
    public static final String DEFAULT_PARAMETERS_FILENAME = "parameters.json";
    public static final String DEFAULT_TEST_INPUT_FILENAME = "test.txt";
    public static final String DEFAULT_TEST_PARAMETERS_FILENAME = "test parameters.json";

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

    /**
     * Defines the location of the puzzle input. The default directory 
     * structure is "<project_dir>/inputs/yearYYYY/dayDD/" and the default
     * file name for the input is "YYYY-DD input.txt", where YYYY is the year
     * and DD is the day.
     * 
     * This is a bit redundant, but it has been the standard for me from the 
     * very beginning, so that's what I'll use to the bitter end.
     * 
     * This method should be overriden, if you're going to use your own 
     * naming scheme.
     * 
     * @param metadata
     * @param filename
     * @return
     */
    public static String inputLocation(Metadata metadata, String filename)
    {
        return String.format(
            "inputs/year%d/day%02d/%d-%02d %s",
            metadata.year(), metadata.day(),
            metadata.year(), metadata.day(),
            filename
        );
    }
    
}
