package fi.tuomax.adventofcode.year2016.day19;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2016, day 19, part 2: 
 * An Elephant Named Joseph.
 * 
 * <p>Part 2 takes too long if the number of elves and the half-way point are
 * calculated every time, which is why they are calculated only once at the
 * beginning of the puzzle. On the next rounds exactly one elf is removed from
 * the circle, and the behaviour of the half-way elf follows a certain pattern,
 * modelling of which is fast.</p>
 * 
 * <table>
 * <tr> <th>Number of elves</th> <th>Half-way</th>   </tr>
 * <tr> <td>10</td>              <td>6</td>          </tr>
 * <tr> <td>9</td>               <td>5</td>          </tr>
 * <tr> <td>8</td>               <td>5</td>          </tr>
 * <tr> <td>7</td>               <td>4</td>          </tr>
 * <tr> <td>6</td>               <td>4</td>          </tr>
 * <tr> <td>5</td>               <td>3</td>          </tr>
 * <tr> <td>4</td>               <td>3</td>          </tr>
 * </table>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2016/day/19">
 *      Puzzle on the Advent of Code website.</a>
 */
public class AnElephantNamedJoseph_Part2
extends AnElephantNamedJoseph
{
    
    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 19, 2,
            "An Elephant Named Joseph", ""
        );
    }

    private Integer numOfElves = 0;

    private Elf halfWay = null;


    @Override
    protected Elf stealFrom(Elf inTurn) 
    {
        if (halfWay == null)
            halfWay = establishHalfway(inTurn);

        Elf oldHalfWay = halfWay;
        if ((numOfElves % 2) == 1)
            halfWay = halfWay.left.left;
        else
            halfWay = halfWay.left;
        numOfElves--;

        return oldHalfWay;
    }


    /**
     * This is called only once, right at the beginning, which guarantees that
     * inTurn is the first elf.
     */
    private Elf establishHalfway(Elf inTurn)
    {
        numOfElves = countElves(inTurn);
        Integer oppositeElf = numOfElves / 2;
        Elf e = inTurn;
        for (int i = 0; i < oppositeElf; i++)
            e = e.left;
        return e;
    }

    private Integer countElves(Elf inTurn)
    {
        Integer numOfElves = 1;
        Elf e = inTurn;
        while (e.left != inTurn) {
            e = e.left;
            numOfElves++;
        }
        return numOfElves;
    }
    
}
