package fi.tuomax.adventofcode.year2016.day22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fi.tuomax.adventofcode.commons.Coordinates;

/**
 * A node from the computer grid of Advent of Code 2016, day 22.
 */
public class Node 
{

    private Coordinates position;

    public Coordinates position()
    {
        return position;
    }

    private Integer size;
    
    public Integer getSize() {
        return size;
    }

    private Integer used;

    public Integer getUsed() {
        return used;
    }

    /**
     * Creates a node.
     * @param input
     *      A line of Advent of Code input.
     */
    public Node(String input)
    {
        Matcher matcher = Pattern.compile("(\\d+)").matcher(input);
        if (!matcher.find())
            throw new IllegalArgumentException("Not enough numbers in the input: " + input);
        Long x = Long.valueOf(matcher.group());
        if (!matcher.find())
            throw new IllegalArgumentException("Not enough numbers in the input: " + input);
        Long y = Long.valueOf(matcher.group());
        position = new Coordinates(x, y);
        if (!matcher.find())
            throw new IllegalArgumentException("Not enough numbers in the input: " + input);
        size = Integer.valueOf(matcher.group());
        if (!matcher.find())
            throw new IllegalArgumentException("Not enough numbers in the input: " + input);
        used = Integer.valueOf(matcher.group());
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Node)) return false;
        Node other = (Node) o;
        return this.position() == other.position();
    }

    public Integer getAvail() 
    {
        return getSize() - getUsed();
    }
    
}
