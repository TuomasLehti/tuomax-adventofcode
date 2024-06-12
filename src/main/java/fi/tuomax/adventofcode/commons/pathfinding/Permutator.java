package fi.tuomax.adventofcode.commons.pathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Arranges a list of objects to all of their possible permutations.
 * A permutation is a way to arrange a set of objects to a linear order.
 * @see https://en.wikipedia.org/wiki/Permutation
 */
public class Permutator<T> {

    public static <T extends Comparable<T>> List<List<T>> getPermutations(List<T> list)
    {
        ArrayList<T> visited = new ArrayList<>();
        ArrayList<T> unvisited = new ArrayList<>(list);
        return permutate(visited, unvisited);
    }

    private static <T extends Comparable<T>> List<List<T>> permutate(ArrayList<T> visited, List<T> unvisited)
    {
        List<List<T>> result = new ArrayList<>();
        if (unvisited.isEmpty()) {
            result.add(new ArrayList<T>(visited));
        } else {
            List<T> newUnvisited = new ArrayList<>(unvisited);
            for (T t : unvisited) {
                visited.add(t);
                newUnvisited.remove(t);
                Collections.sort(newUnvisited);
                result.addAll(permutate(visited, newUnvisited));
                newUnvisited.add(t);
                visited.remove(t);
            }
        }
        return result;
    }
    
}
