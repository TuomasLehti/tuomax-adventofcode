package fi.tuomax.adventofcode.framework;

import java.util.List;

public abstract class Solver 
{

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

    public Solver(List<String> input)
    {
        this.parser = manufactureParser(input);
        setMetadata();
    }

    protected abstract void setMetadata();

    protected abstract Parser manufactureParser(List<String> input);

    public void run()
    {
        stopwatch.start();
        parser.parse();
        solve();
        stopwatch.stop();
    }

    protected abstract void solve();

    protected void setAnswer(Integer i)
    {
        answer = i.toString();
    }

}
