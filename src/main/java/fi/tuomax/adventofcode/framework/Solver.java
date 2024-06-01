package fi.tuomax.adventofcode.framework;

import java.util.List;

public abstract class Solver 
{

    protected Parser parser;

    protected String answer = "";

    private Stopwatch stopwatch = new Stopwatch();
    
    public Solver(List<String> input)
    {
        this.parser = manufactureParser(input);
    }

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
