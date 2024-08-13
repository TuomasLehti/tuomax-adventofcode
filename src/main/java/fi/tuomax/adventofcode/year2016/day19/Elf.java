package fi.tuomax.adventofcode.year2016.day19;

public class Elf 
{

    public int num;

    public int numOfPresents = 1;

    public Elf left = null;

    public Boolean steal()
    {
        Elf stealFrom = left;
        while (stealFrom != this && stealFrom.numOfPresents == 0)
            stealFrom = stealFrom.left;
        if (stealFrom == this)
            return false;
        this.numOfPresents += stealFrom.numOfPresents;
        stealFrom.numOfPresents = 0;
        return true;
    }

}
