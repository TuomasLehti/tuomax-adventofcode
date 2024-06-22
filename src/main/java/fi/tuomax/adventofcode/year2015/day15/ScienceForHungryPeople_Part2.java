package fi.tuomax.adventofcode.year2015.day15;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class ScienceForHungryPeople_Part2
extends ScienceForHungryPeople_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 15, 2, 
            "Science for Hungry People", ""
        );
    }

    @Override
    protected void compareRecipe(Ingredient mixed) 
    {
        if (mixed.calories().equals(500L))
            bestScore = Math.max(bestScore, mixed.score());
    }  
}
