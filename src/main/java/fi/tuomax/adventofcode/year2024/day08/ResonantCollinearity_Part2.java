package fi.tuomax.adventofcode.year2024.day08;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;

/**
 * <p>Solves Advent of Code 2024, day 8, part 2:
 * Resonant Collinearity.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/8">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ResonantCollinearity_Part2
extends ResonantCollinearity_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 8, 2,
            "Resonant Collinearity", ""
        );
    }

    @Override
    protected void addAntinodes(Antenna one, Antenna other)
    {
        Coordinates delta = delta(one.position(), other.position());
        Coordinates antinode = one.position().translate(delta);
        while (inBounds(antinode)) {
            antinodes.add(antinode);
            antinode = antinode.translate(delta);
        }
        antinodes.add(one.position());
        antinodes.add(other.position());
    }

}
