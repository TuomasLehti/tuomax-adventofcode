package fi.tuomax.adventofcode.framework;

import java.util.List;

public abstract class Solver 
{

    protected Parser parser;

    protected String answer = "";
    
    public Solver(List<String> input)
    {
        this.parser = manufactureParser(input);
    }

    protected abstract Parser manufactureParser(List<String> input);

    public void run()
    {
        parser.parse();
        solve();
    }

    protected abstract void solve();

}
