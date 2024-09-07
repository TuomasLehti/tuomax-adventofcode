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
     * 
     * Parameters are read from a json file in the puzzle input directory.
     * The json file should hold a single object, who has two children, one for
     * both both parts of the puzzle. The name of the children of the root
     * should be part1 and part2.
     */
    protected JSONObject parameters = null;

    /**
     * Sets the parameteres of the puzzle, if they need to be read from 
     * somwhere that is not the standard puzzle input directory.
     */
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
        readParametersFromStandardInputDirectory();
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

    private void readParametersFromStandardInputDirectory()
    {
        File paramsFile = new File(
            InputFactory.inputLocation(
                metadata, 
                InputFactory.DEFAULT_PARAMETERS_FILENAME
            )
        );
        try {
            String content = new String(
                    Files.readAllBytes(paramsFile.toPath()));
            setParameters(new JSONObject(content));
        } catch (IOException e) {
            // System.out.println(e.getMessage());
            /* Parameter file not found, just continue without params. */
        }
    }

    protected abstract void solve();

    /**
     * A convenience method for setting the answer.
     */
    protected void setAnswer(Integer i)
    {
        answer = i.toString();
    }

    /**
     * A convenience method for setting the answer.
     */
    protected void setAnswer(Long l)
    {
        answer = l.toString();
    }

    /**
     * A convenience method for setting the answer.
     */
    protected void setAnswer(String s)
    {
        answer = s;
    }

    /**
     * A convenience method for getting a parameter for this part of the
     * puzzle.
     */
    protected String getParamStr(String name)
    {
        String partName = String.format("part%d", getMetadata().part());
        return parameters.getJSONObject(partName).getString(name);
    }

    /**
     * A convenience method for getting a parameter for this part of the
     * puzzle.
     */
    protected Integer getParamInt(String name)
    {
        String partName = String.format("part%d", getMetadata().part());
        return parameters.getJSONObject(partName).getInt(name);
    }

    /**
     * A convenience method for getting a parameter for this part of the
     * puzzle.
     */
    protected Boolean getParamBool(String name)
    {
        String partName = String.format("part%d", getMetadata().part());
        return parameters.getJSONObject(partName).getBoolean(name);
    }

    /**
     * The convenience method for getting the expected answer is exposed to the
     * public, because for example the printers need it.
     */
    public String getExpectedAnswer()
    {
        try {
            return getParamStr("expected_answer");
        } catch (NullPointerException e) {
            return "";
        }
    }

}
