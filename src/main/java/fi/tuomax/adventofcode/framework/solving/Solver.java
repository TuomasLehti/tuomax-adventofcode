package fi.tuomax.adventofcode.framework.solving;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public abstract class Solver 
{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private Metadata metadata = null;

    /**
     * Metadata is the data associated with the puzzle, but not used in the
     * solving of the puzzle, for example the year and the day of the puzzle.
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * A factory method for creating an instance of Metadata.
     */
    protected abstract Metadata manufactureMetadata();

    /**
     * A parser parses the puzzle input to a useful form. Solvers should get
     * their input by casting this parser field to an appropriate parser
     * class.
     */
    protected Parser parser;

    /**
     * A factory method for creating an instance of an appropriate parser
     * for this puzzle.
     */
    protected abstract Parser manufactureParser(List<String> input);

    /**
     * Parameters of the puzzle are the bits of knowledge needed to solve
     * the puzzle, which are not included in the puzzle input itself.
     */
    protected JSONObject parameters = null;

    public void setParameters(JSONObject parameters) 
    {
        this.parameters = parameters;
    }

    private String answer = "";

    public String getAnswer() {
        return answer;
    }

    private Stopwatch stopwatch = new Stopwatch();
    
    public Stopwatch getStopwatch() {
        return stopwatch;
    }

    public Solver()
    {
        this.metadata = manufactureMetadata();
    }

    /**
     * Runs the solver with a given input.
     */
    public void run(List<String> input)
    {
        this.parser = manufactureParser(input);
        stopwatch.start();
        parser.parse();
        solve();
        stopwatch.stop();
    }

    /**
     * Runs the solver with default input.
     */
    public void run()
    {
        File paramsFile = new File(
            InputFactory.inputLocation(
                metadata, 
                InputFactory.DEFAULT_PARAMETERS_FILENAME
            )
        );
        try {
            String content = new String(Files.readAllBytes(paramsFile.toPath()));
            setParameters(new JSONObject(content));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            /* Parameter file not found, just continue without params. */
        }
        try {
            run(
                InputFactory.inputFromMetadata(
                    metadata, 
                    InputFactory.DEFAULT_INPUT_FILENAME
                )
            );
        } catch (IOException e) {
            LOGGER.warn("Unable to read input: " + e.toString());
            run(new ArrayList<String>());
        }
    }

    protected abstract void solve();

    protected void setAnswer(Integer i)
    {
        answer = i.toString();
    }

    protected void setAnswer(Long l)
    {
        answer = l.toString();
    }

    protected void setAnswer(String s)
    {
        answer = s;
    }

}
