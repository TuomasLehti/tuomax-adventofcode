package fi.tuomax.adventofcode.year2017.day11;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2017, day 11, part 1:
 * Hex Ed.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/11">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class HexEd_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 11, 1,
            "Hex Ed", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new HexEd_Parser(input);
    }

    protected Map<Integer, Coordinates> hexTranslations = new HashMap<>();

    protected void populateHexTranslations()
    {
        hexTranslations.put(
            Direction.getInstance(Direction.NORTH).get(), 
            Coordinates.fromInteger(0, 2)
        );
        hexTranslations.put(
            Direction.getInstance(Direction.NORTHEAST).get(), 
            Coordinates.fromInteger(1, 1)
        );
        hexTranslations.put(
            Direction.getInstance(Direction.SOUTHEAST).get(), 
            Coordinates.fromInteger(1, -1)
        );
        hexTranslations.put(
            Direction.getInstance(Direction.SOUTH).get(), 
            Coordinates.fromInteger(0, -2)
        );
        hexTranslations.put(
            Direction.getInstance(Direction.SOUTHWEST).get(), 
            Coordinates.fromInteger(-1, -1)
        );
        hexTranslations.put(
            Direction.getInstance(Direction.NORTHWEST).get(), 
            Coordinates.fromInteger(-1, 1)
        );
    }

    protected Long hexTaxicabDistance(Coordinates from)
    {
        if (Math.abs(from.y()) <= Math.abs(from.x())) {
            return Math.abs(from.x());
        } else {
            return
                Math.abs(from.x()) + (Math.abs(from.y()) - Math.abs(from.x())) / 2;
        }
    }

    @Override
    protected void solve()
    {
        populateHexTranslations();
        Coordinates childPosition = Coordinates.ORIGIN;
        for (Direction direction : ((HexEd_Parser) parser).getDirections()) {
            childPosition = childPosition.translate(hexTranslations.get(direction.get()));
        }
        setAnswer(hexTaxicabDistance(childPosition));
    }

}



/**
 * System for coordinates of the hex grid.
 *   _____         _____         _____         _____         _____         _____         _____  
 *  /     \       /     \       /     \       /     \       /     \       /     \       /     \ 
 * / -2,4  \_____/  0,4  \_____/  2,4  \_____/       \_____/       \_____/       \_____/       \
 * \       /     \       /     \       /     \       /     \       /     \       /     \       /
 *  \_____/ -1,3  \_____/  1,3  \_____/  3,3  \_____/       \_____/       \_____/       \_____/ 
 *  /     \       /     \       /     \       /     \       /     \       /     \       /     \ 
 * / -2,2  \_____/  0,2  \_____/  2,2  \_____/       \_____/       \_____/       \_____/       \
 * \       /     \       /     \       /     \       /     \       /     \       /     \       /
 *  \_____/ -1,1  \_____/  1,1  \_____/  3,1  \_____/       \_____/       \_____/       \_____/ 
 *  /     \       /     \       /     \       /     \       /     \       /     \       /     \ 
 * / -2,0  \_____/  0,0  \_____/  2,0  \_____/       \_____/       \_____/       \_____/       \
 * \       /     \       /     \       /     \       /     \       /     \       /     \       /
 *  \_____/ -1,-1 \_____/  1,-1 \_____/  3,-1 \_____/       \_____/       \_____/       \_____/ 
 *  /     \       /     \       /     \       /     \       /     \       /     \       /     \ 
 * / -2,-2 \_____/  0,-2 \_____/ 2,-2  \_____/       \_____/       \_____/       \_____/       \
 * \       /     \       /     \       /     \       /     \       /     \       /     \       /
 *  \_____/ -1,-3 \_____/  1,-3 \_____/  3,-3 \_____/       \_____/       \_____/       \_____/ 
 *  /     \       /     \       /     \       /     \       /     \       /     \       /     \ 
 * / -2,-4 \_____/  0,-4 \_____/  2,-4 \_____/       \_____/       \_____/       \_____/       \
 * \       /     \       /     \       /     \       /     \       /     \       /     \       /
 *  \_____/       \_____/       \_____/       \_____/       \_____/       \_____/       \_____/ 
 *  /     \       /     \       /     \       /     \       /     \       /     \       /     \ 
 * /       \_____/       \_____/       \_____/       \_____/       \_____/       \_____/       \
 * \       /     \       /     \       /     \       /     \       /     \       /     \       /
 *  \_____/       \_____/       \_____/       \_____/       \_____/       \_____/       \_____/ 
 *  /     \       /     \       /     \       /     \       /     \       /     \       /     \ 
 * /       \_____/       \_____/       \_____/       \_____/       \_____/       \_____/       \
 * \       /     \       /     \       /     \       /     \       /     \       /     \       /
 *  \_____/       \_____/       \_____/       \_____/       \_____/       \_____/       \_____/ 
 *  /     \       /     \       /     \       /     \       /     \       /     \       /     \ 
 * /       \_____/       \_____/       \_____/       \_____/       \_____/       \_____/       \
 * \       /     \       /     \       /     \       /     \       /     \       /     \       /
 *  \_____/       \_____/       \_____/       \_____/       \_____/       \_____/       \_____/ 
 */