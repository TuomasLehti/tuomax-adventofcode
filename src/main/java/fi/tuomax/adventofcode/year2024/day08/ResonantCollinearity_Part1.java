package fi.tuomax.adventofcode.year2024.day08;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Solves Advent of Code 2024, day 8, part 1:
 * Resonant Collinearity.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/8">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ResonantCollinearity_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 8, 1,
            "Resonant Collinearity", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new ResonantCollinearity_Parser(input);
    }

    protected ResonantCollinearity_Parser getParser()
    {
        return (ResonantCollinearity_Parser) parser;
    }

    protected Boolean inBounds(Coordinates coordinates)
    {
        return 
            coordinates.x() >= 0 && 
            coordinates.x() < getParser().getWidth() &&
            coordinates.y() >= 0 && 
            coordinates.y() < getParser().getHeight();
    }

    protected Coordinates delta(Coordinates one, Coordinates other)
    {
        Long dx = one.x() - other.x();
        Long dy = one.y() - other.y();
        return new Coordinates(dx, dy);
    }

    protected Set<Coordinates> antinodes = new HashSet<>();

    protected void addAntinodes(Antenna one, Antenna other)
    {
        Coordinates delta = delta(one.position(), other.position());
        Coordinates antinode = one.position().translate(delta);
        if (inBounds(antinode))
            antinodes.add(antinode);
    }

    @Override
    protected void solve()
    {
        antinodes.clear(); // don't know why, but it must be done
        for (Antenna one : getParser().getAntennas()) 
            for (Antenna other : getParser().getAntennas()) {
                if (one.equals(other)) continue;
                if (!one.frequency().equals(other.frequency())) continue;
                addAntinodes(one, other);
            }

        setAnswer(antinodes.size());
    }

}
