package fi.tuomax.adventofcode.framework.solving;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public abstract class Solver 
{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private Metadata metadata = null;

    public Metadata getMetadata() {
        return metadata;
    }

    protected Parser parser;

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

    protected abstract Metadata manufactureMetadata();

    protected abstract Parser manufactureParser(List<String> input);

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
        try {
            run(InputFactory.inputFromMetadata(metadata, InputFactory.DEFAULT_INPUT_FILENAME));
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
