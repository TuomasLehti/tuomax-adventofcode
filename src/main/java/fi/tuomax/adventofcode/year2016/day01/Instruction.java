package fi.tuomax.adventofcode.year2016.day01;

import fi.tuomax.adventofcode.framework.parsing.Parseable;

public class Instruction 
extends Parseable
{

    public Instruction(String aocInput) 
    {
        super(aocInput);
        turn = aocInput.charAt(0);
        blocks = Integer.valueOf(aocInput.substring(1));
    }

    private char turn;

    public char getTurn() 
    {
        return turn;
    }

    private int blocks;

    public int getBlocks() 
    {
        return blocks;
    }

}
