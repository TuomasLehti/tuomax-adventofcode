package fi.tuomax.adventofcode.year2015.day15;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class ScienceForHungryPeople_Parser 
extends Parser
{

    private List<Ingredient> ingredients = new ArrayList<>();

    public List<Ingredient> getIngredients() 
    {
        return ingredients;
    }

    public ScienceForHungryPeople_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input)
            ingredients.add(Ingredient.fromInput(line));
    }
    
}
