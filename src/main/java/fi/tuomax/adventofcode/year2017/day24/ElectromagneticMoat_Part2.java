package fi.tuomax.adventofcode.year2017.day24;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Solves Advent of Code 2017, day 24, part 2:
 * Electromagnetic Moat.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/24">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ElectromagneticMoat_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 24, 2,
            "Electromagnetic Moat", ""
        );
    }
    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new ElectromagneticMoat_Parser(input);
    }

    @Override
    protected void solve()
    {
        Set<Component> components = ((ElectromagneticMoat_Parser) parser).getComponents();
        Component starter = Component.getStarterInstance();
        bridgify(starter, components, 0L, 0L);
        setAnswer(maxStrength);
    }

    private Long maxStrength = Long.MIN_VALUE;

    private Long maxLength = Long.MIN_VALUE;

    private void bridgify(Component current, Set<Component> available, Long curStrength, Long curLength)
    {
        
        if (curLength.equals(maxLength)) {
            maxStrength = Math.max(curStrength, maxStrength);
        } else if (curLength > maxLength) {
            maxLength = curLength;
            maxStrength = curStrength;

        }
        Set<Component> possibles = new HashSet<>();

        for (Component component : available)
            if (current.isConnectableTo(component))
                possibles.add(component);

        for (Component component : possibles) {
            available.remove(component);
            current.connectTo(component);
            bridgify(component, available, curStrength + component.getLength(), curLength + 1);
            current.disconnectFrom(component);
            available.add(component);
        }
    }

}
// 1488 too low