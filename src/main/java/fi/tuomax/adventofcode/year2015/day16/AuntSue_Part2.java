package fi.tuomax.adventofcode.year2015.day16;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * Solves Advent of Code 2015, day 16, part 2:
 * Aunt Sue
 * @see 
 *      <a href="https://adventofcode.com/2015/day/16">
 *      Puzzle on the Advent of Code website.</a>
 */
public class AuntSue_Part2 
extends AuntSue_Solver
{

    @Override
    protected Boolean equalSues(Sue ticker, Sue sue) 
    {
        for (Compound c : Compound.values()) {
            if (ticker.hasCompound(c) && sue.hasCompound(c)) {
                switch (c) {

                    /* In this switch statement the cases do not automatically
                     * return, which is why the break is needed. If the break
                     * isn't there, all compounds will be handled by the 
                     * default case, and cats, trees, pomeranianx and goldfish
                     * will be handled twice. */

                    case CATS:
                    case TREES:
                        if (ticker.getAmount(c) >= sue.getAmount(c)) 
                            return false;
                        break; 

                    case POMERANIANS:
                    case GOLDFISH:
                        if (ticker.getAmount(c) <= sue.getAmount(c)) 
                            return false;
                        break;

                    default:
                        if (!ticker.getAmount(c).equals(sue.getAmount(c))) 
                            return false;
                        break;
                }
            }
        }
        return true;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 16, 2, 
            "Aunt Sue", ""
        );
    }
    
}
