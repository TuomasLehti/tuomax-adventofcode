package fi.tuomax.adventofcode.year2017.day11;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;

/**
 * <p>Solves Advent of Code 2017, day 11, part 2:
 * Hex Ed.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/11">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class HexEd_Part2
extends HexEd_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 11, 2,
            "Hex Ed", ""
        );
    }

    @Override
    protected void solve()
    {
        populateHexTranslations();
        Coordinates childPosition = Coordinates.ORIGIN;
        Long furthest = Long.MIN_VALUE;
        for (Direction direction : ((HexEd_Parser) parser).getDirections()) {
            childPosition = childPosition.translate(hexTranslations.get(direction.get()));
            furthest = Math.max(furthest, hexTaxicabDistance(childPosition));
        }
        setAnswer(furthest);
    }

}
