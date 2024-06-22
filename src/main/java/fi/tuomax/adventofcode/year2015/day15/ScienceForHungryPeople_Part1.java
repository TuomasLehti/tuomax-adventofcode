package fi.tuomax.adventofcode.year2015.day15;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class ScienceForHungryPeople_Part1 
extends ScienceForHungryPeople_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 15, 1, 
            "Science for Hungry People", ""
        );
    }

    @Override
    protected void compareRecipe(Ingredient mixed) 
    {
        bestScore = Math.max(bestScore, mixed.score());
    }  
}
