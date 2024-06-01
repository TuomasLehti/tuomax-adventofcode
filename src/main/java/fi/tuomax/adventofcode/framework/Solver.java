package fi.tuomax.adventofcode.framework;

import java.util.List;

public abstract class Solver 
{

    protected Parser parser;
    
    public Solver(List<String> input)
    {
        this.parser = manufactureParser(input);
    }

    protected abstract Parser manufactureParser(List<String> input);

}
