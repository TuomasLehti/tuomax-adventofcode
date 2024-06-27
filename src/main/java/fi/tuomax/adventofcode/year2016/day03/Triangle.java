package fi.tuomax.adventofcode.year2016.day03;

import fi.tuomax.adventofcode.framework.parsing.Parseable;

public class Triangle 
extends Parseable
{

    private Integer[] sides = new Integer[3];

    public Triangle(String aocInput) 
    {
        super(aocInput);
        String[] parts = aocInput.replaceAll(" +", " ")
                                 .replaceAll("^ ", "")
                                 .split(" ");
        sides[0] = Integer.valueOf(parts[0]);
        sides[1] = Integer.valueOf(parts[1]);
        sides[2] = Integer.valueOf(parts[2]);
    }

    public Triangle(Integer s1, Integer s2, Integer s3)
    {
        super("");
        sides[0] = s1;
        sides[1] = s2;
        sides[2] = s3;
    }

    public Boolean isPossible() 
    {
        return 
            (sides[0] + sides[1]) > sides[2] &&
            (sides[0] + sides[2]) > sides[1] &&
            (sides[1] + sides[2]) > sides[0];
    }
    
}
