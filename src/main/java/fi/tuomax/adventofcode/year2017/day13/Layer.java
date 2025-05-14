package fi.tuomax.adventofcode.year2017.day13;

public class Layer {

    private Integer depth = -1;

    public Integer getDepth() 
    {
        return depth;
    }

    private Integer range = -1;

    public Integer getRange() 
    {
        return range;
    }

    /** After this many cycles the scanner has returned to the first position. */
    private Integer cycle;

    public Layer(String input)
    {
        this.depth = Integer.valueOf(input.split(": ")[0]);
        this.range = Integer.valueOf(input.split(": ")[1]);
        this.cycle = (this.range - 1) * 2;
    }

    public Boolean blocksAt(Integer picosecond)
    {
        return (picosecond % cycle) == 0;
    }
    
}