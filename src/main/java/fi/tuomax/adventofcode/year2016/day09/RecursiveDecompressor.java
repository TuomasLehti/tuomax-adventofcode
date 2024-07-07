package fi.tuomax.adventofcode.year2016.day09;

/** Decompresses input from Aoc 2016, day 9, part 2. */
public class RecursiveDecompressor 
extends Decompressor
{

    /**
     * Counts the length of the uncompressed string. For part 2 we must 
     * decompress the markers inside the sequence, so we call the 
     * demompressor recursively.
     */
    @Override
    protected Long getSectionLength(String section)
    {
        if  (!section.contains("(")) {
            return super.getSectionLength(section);
        } 
        return decompress(section);
    }    
    
}
