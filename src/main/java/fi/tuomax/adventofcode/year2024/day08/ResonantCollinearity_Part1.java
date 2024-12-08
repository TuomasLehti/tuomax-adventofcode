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

    @Override
    protected void solve()
    {
        Set<Coordinates> antinodes = new HashSet<>();

        for (Antenna one : getParser().getAntennas()) 
            for (Antenna other : getParser().getAntennas()) {
                if (one.equals(other)) continue;
                if (!one.frequency().equals(other.frequency())) continue;
                Long dx = one.position().x() - other.position().x();
                Long dy = one.position().y() - other.position().y();
                Coordinates delta = new Coordinates(dx, dy);
                Coordinates antinode = one.position().translate(delta);
                if (antinode.x() >= 0 && antinode.x() < getParser().getWidth() &&
                    antinode.y() >= 0 && antinode.y() < getParser().getHeight())
                    antinodes.add(antinode);
            }

        setAnswer(antinodes.size());
    }

}
