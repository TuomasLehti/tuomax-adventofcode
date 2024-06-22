package fi.tuomax.adventofcode.year2015.day15;

import java.util.List;

/**
 * An ingredient of Advent of Code 2015, day 15. It includes the scores for
 * each property. The puzzle talks about properties and their values, but a 
 * value of a property can be taken as the score of that property for one
 * teaspoon.
 */
public record Ingredient(
    String name,
    Long capacity,
    Long durability,
    Long flavor,
    Long texture,
    Long calories
) {

    /**
     * Parses input to ingredient.
     */
    public static Ingredient fromInput(String input)
    {
        String[] parts = input.replaceAll(",|:", "").split(" ");
        return new Ingredient(
            parts[0],
            Long.valueOf(parts[2]), 
            Long.valueOf(parts[4]), 
            Long.valueOf(parts[6]), 
            Long.valueOf(parts[8]), 
            Long.valueOf(parts[10])
        );
    }

    public static Ingredient emptyInstance(String name)
    {
        return new Ingredient(name,
         0L,
         0L,
         0L,
         0L,
         0L
         );
    }

    /**
     * Measures an amount of this ingredient. (Puzzle talks about choosing.)
     * The scores of this ingredient's properties are the scores for a single 
     * teaspoonful, so timesing is all that needs to be done.
     */
    public Ingredient measure(Long teaspoons)
    {
        return new Ingredient(
            name, 
            teaspoons * capacity, 
            teaspoons * durability, 
            teaspoons * flavor, 
            teaspoons * texture, 
            teaspoons * calories
        );
    }

    /**
     * Mixes two ingredients. A score of a mix of different measured 
     * ingredients is simply the scores of the ingredients added together.
     */
    public Ingredient mix(Ingredient other)
    {
        return new Ingredient(
            name,
            capacity + other.capacity,
            durability + other.durability,
            flavor + other.flavor,
            texture + other.texture,
            calories + other.calories
        );
    }
    
    /**
     * There are more than two ingredients, so all of them must be added
     * together, to get the final scores of each property.
     */
    public static Ingredient mix(List<Ingredient> ingredients)
    {
        Ingredient mixed = Ingredient.emptyInstance("mix");
        for (Ingredient ingredient : ingredients) {
            mixed = mixed.mix(ingredient);
        }
        return mixed;
    }

    /**
     * Counts the score for this cookie.
     */
    public Long score() {
        if (capacity < 0 || durability < 0 || flavor < 0 || texture < 0) 
            return 0L;
        return capacity * durability * flavor * texture;
    }
}
