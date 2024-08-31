package fi.tuomax.adventofcode.year2022.day03;

import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2022, day 3:
 * Rucksack Reorganization.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/3">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public abstract class RucksackReorganization_Solver
extends Solver
{

    private Boolean allStringsContain(String[] lines, Character contains) {
        for (String line : lines)
            if (!line.contains(contains.toString()))
                return false;
        return true;
    }

    private Character firstCommonChar(String comparee, String[] lines)
    {
        for (Character c : comparee.toCharArray()) {
            if (allStringsContain(lines, c))
                return c;
        }
        return null;
    }

    private Integer itemPriority(Character item) 
    {
        char c = (char) item;
        return (c >= 'A' && c <= 'Z') ? (int) c - 'A' + 27: (int) c - 'a' + 1;
    }

    @Override
    protected void solve()
    {
        Map<String, String[]> rucksacks = 
                ((RucksackReorganization_Parser) parser).getRucksacks();
        Integer result = 0;
        for (String line : rucksacks.keySet()) {
            result += itemPriority(firstCommonChar(line, rucksacks.get(line)));
        }
        setAnswer(result);
    }

}
