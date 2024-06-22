package fi.tuomax.adventofcode.year2015.day15;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

public abstract class ScienceForHungryPeople_Solver 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new ScienceForHungryPeople_Parser(input);
    }

    protected Long bestScore = Long.MIN_VALUE;

    @Override
    protected void solve() 
    {
        List<Long> current = new ArrayList<>();
        cookbook(current, getParser().getIngredients().size() - 1, 100L);
        setAnswer(bestScore);
    }

    private ScienceForHungryPeople_Parser getParser()
    {
        return (ScienceForHungryPeople_Parser) parser;
    }

    /**
     * Goes through every possible recipe and cooks it.
     * @param current
     *      The amount of each ingredient.
     * @param depth
     *      How many ingredients have not been measured.
     * @param left
     *      How many teaspoons are left.
     */
    public void cookbook(List<Long> current, Integer depth, Long left)
    {
        if (depth >= 0 && left == 0) return;
        if (depth == 0) {
            current.add(left);
            cook(current);            
            current.remove(current.size()-1);
            return;
        } else {
            for (long i = left; i > 0; i--) {
                current.add(i);
                cookbook(current, depth - 1, left - i);
                current.remove(current.size()-1);
            }
        }
    }

    /**
     * Cooks a recipe, in other words counts the score of a set of amounts.
     * @param current
     *      The recipe. How many teaspoons of each ingredient to include.
     */
    private void cook(List<Long> current) 
    {
        if (current.size() != getParser().getIngredients().size())
            throw new IllegalStateException("List of ingredients and list of amounts are of different lengths.");
        
        // A list of measurements
        List<Ingredient> measured = new ArrayList<>();
        for (int i = 0; i < getParser().getIngredients().size(); i++)
            measured.add(getParser().getIngredients().get(i).measure(current.get(i)));
        Ingredient mixed = Ingredient.mix(measured);
        compareRecipe(mixed);
    }

    protected abstract void compareRecipe(Ingredient mixed);
    
}
