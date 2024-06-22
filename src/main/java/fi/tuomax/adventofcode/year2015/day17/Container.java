package fi.tuomax.adventofcode.year2015.day17;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A linked list of containers from Advent of Code 2015, day 17.
 */
public class Container 
{

    /** The amount of liquid this container can hold. */
    private Integer capacity;

    /** 
     * The amount of liquid this container and all subsequent containers
     * can hold.
     */
    private Integer capacityLeft;

    private Boolean full;

    private Container next = null;

    public Container(Integer capacity)
    {
        this.capacity = capacity;
        this.capacityLeft = capacity;
    }

    public Boolean isFull() 
    {
        return full;
    }

    /** 
     * Returns the amount of liquid this container can hold. 
     */
    public Integer getCapacity() 
    {
        return capacity;
    }

    /** 
     * Returns the amount of liquid this container and all subsequent 
     * containers in the list can hold.
     */
    public Integer getCapacityLeft() 
    {
        return capacityLeft;
    }

    public Container getNext() 
    {
        return next;
    }

    public void add(Container c) 
    {
        if (next == null) {
            next = c;
        } else {
            next.add(c);
        }
        capacityLeft = capacity + next.getCapacityLeft();
    }

    /**
     * Returns the size of the linked list.
     */
    public Integer size()
    {
        if (next == null)
            return 1;
        else    
            return next.size() + 1;
    }

    /**
     * Returns the status of the containers as a string. Filled containers
     * are surrounded by brackets.
     */
    public String asString()
    {
        String format = full ? "[%02d]" : " %02d ";
        return String.format(format, capacity);
    }

    /**
     * Tries to fill the list of containers.
     */
    public Set<String> fill(Integer liquidAmount, List<String> anAnswer)
    {
        HashSet<String> result = new HashSet<>();

        /* There's no point in doing more work, if the remaining containers
         * can't fit the amount that's left. */
        if (capacityLeft < liquidAmount)
            return result;

        /* If this container can be filled with the amount of liquid left... */
        if (capacity <= liquidAmount) {

            /* Fill it and add it to the solution in the making. */
            full = true;
            anAnswer.add(asString()); // with brackets

            /* If the amount of liquid left fills this container exactly, we've
             * found a solution to the problem. */
            if (capacity.equals(liquidAmount)) {
                result.add(String.join("", anAnswer));
            }

            /* We must check the remaining containers even if we found a 
             * solution, because next containers might have combinations that
             * fill up exactly. */
            if (next != null)
                result.addAll(next.fill(liquidAmount - capacity, anAnswer));

            /* Remove the full container from the answer in the making. */
            anAnswer.remove(anAnswer.size() - 1); 
        }

        /* In the case that we can't or won't fill this container with 
         * liquid... */
        full = false;
        anAnswer.add(asString()); // without brackets
        
        /* Keep checking for other combinations. */
        if (next != null)
            result.addAll(next.fill(liquidAmount, anAnswer));
        
        /* Remove the empty container from the answer in the making. */
        anAnswer.remove(anAnswer.size() - 1);
        return result;
    }
    
}
