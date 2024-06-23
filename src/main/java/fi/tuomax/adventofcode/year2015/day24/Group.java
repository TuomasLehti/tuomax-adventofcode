package fi.tuomax.adventofcode.year2015.day24;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * A group of packages.
 */
public class Group 
{

    private Deque<Integer> packages = new ArrayDeque<>();

    private Long weight = 0L;

    private Long quantumEntanglement = 1L;

    public Group() {}

    public Group(List<Integer> paggages)
    {
        for (Integer baggage : paggages)
            push(baggage);
    }

    public Integer pop()
    {
        Integer baggage = packages.pop();
        weight -= baggage;
        quantumEntanglement /= baggage;
        return baggage;
    }

    public void push(Integer baggage)
    {
        packages.push(Integer.valueOf(baggage));
        weight += baggage;
        quantumEntanglement *= baggage;
    }

    public Boolean empty()
    {
        return packages.isEmpty();
    }

    public Group copy()
    {
        Group cache = new Group();
        Group copy = new Group();
        while (!empty())
            cache.push(pop());
        while (!cache.empty()) {
            Integer baggage = cache.pop();
            copy.push(baggage);
            push(baggage);
        }
        return copy;
    }

    public Long weight()
    {
        return weight;
    }

    public Long quantumEntanglement()
    {
        return quantumEntanglement;
    }

    public Integer numOfPackages()
    {
        return packages.size();
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Group cache = new Group();
        while (!empty()) {
            Integer popper = pop();
            if (sb.length() > 0) sb.append(" ");
            sb.append(popper);
            cache.push(popper);
        }
        while (!cache.empty())
            push(cache.pop());
        return sb.toString();
    }
    
}
