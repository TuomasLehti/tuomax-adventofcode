package fi.tuomax.adventofcode.framework;

/**
 * Times solvers.
 */
public class Stopwatch {

    private Long startMillis = -1l;

    private Long stopMillis = -1l;

    public void start() 
    {
        startMillis = System.currentTimeMillis();
    }

    public void stop() 
    {
        stopMillis = System.currentTimeMillis();
    }

    public Long elapsed() 
    {
        return stopMillis - startMillis;
    }

    public String toString() 
    {
        return String.format("%.3f seconds", elapsed()/1000f);
    }
    
}
