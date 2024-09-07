package fi.tuomax.adventofcode.year2022.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fi.tuomax.adventofcode.commons.Grid;

/**
 * A very simplified version of character recognizion for the puzzles from
 * Advent of Code. Recognizes only upper case letters for now.
 */
public class CharacterRecognizer 
{

    private static List<CharacterArchetype> archetypes = new ArrayList<>();

    static {
        populateArchetypes();
    }

    /**
     * Tries to recognize a character.
     * @param input
     *      The character to be recognized as a flattened 5x5 grid.
     * @return
     *      The character which best matches the input.
     */
    public static Character recognize(String input) 
    {
        for (CharacterArchetype archetype : archetypes)
            archetype.compareAgainst(input);
        Collections.sort(archetypes);
        return archetypes.get(archetypes.size() - 1).getCharacter();
    }

    public static Character recognize(String input, Integer width, Integer height) 
    {
        return recognize(normalizeInput(input, width, height));
    }

    private static Grid<Boolean> inputToGrid(String input, Integer width, Integer height)
    {
        Grid<Boolean> result = new Grid<>(width, height);
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                result.set(col, row, input.charAt(row * width + col) == 'X');
        return result;
    }

    private static Grid<Boolean> expand(Grid<Boolean> input, int xFactor, int yFactor)
    {
        Integer targetWidth = input.width() * xFactor;
        Integer targetHeight = input.height() * yFactor;
        Grid<Boolean> result = new Grid<>(targetWidth, targetHeight);
        for (int row = 0; row < input.height(); row++)
            for (int col = 0; col < input.width(); col++)
                for (int x = 0; x < xFactor; x++)
                    for (int y = 0; y < yFactor; y++)
                        result.set(col * xFactor + x, row * yFactor + y, input.get(col, row));
        return result;
    }

    private static Grid<Boolean> condense(Grid<Boolean> input, int xFactor, int yFactor)
    {
        Integer targetWidth = input.width() / xFactor;
        Integer targetHeight = input.height() / yFactor;
        Grid<Boolean> result = new Grid<>(targetWidth, targetHeight);
        for (int row = 0; row < targetWidth; row++)
            for (int col = 0; col < targetHeight; col++) {

                int pixelsOn = 0;
                for (int x = 0; x < xFactor; x++)
                    for (int y = 0; y < yFactor; y++)
                        if (input.get(col * xFactor + x, row * yFactor + y))
                            pixelsOn++;
                result.set(col, row, ((float) pixelsOn / (xFactor * yFactor)) >= 0.5);
            }
        return result;
    }

    private static void print(Grid<Boolean> input)
    {
        for (int row = 0; row < input.height(); row++) {
            for (int col = 0; col < input.width(); col++)
                System.out.print(input.get(col, row) ? 'X' : " ");
            System.out.println();
        }    
    }

    public static String gridToString(Grid<Boolean> input)
    {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < input.height(); row++) 
            for (int col = 0; col < input.width(); col++)
                sb.append(input.get(col, row) ? 'X' : " ");
        return sb.toString();
    }

    private static String normalizeInput(String input, Integer width, Integer height) 
    {
        Grid<Boolean> inputGrid = inputToGrid(input, width, height);
        Grid<Boolean> expanded = expand(inputGrid, 5, 5);
        Grid<Boolean> condensed = condense(expanded, 4, 6);
        return gridToString(condensed);
    }

    private static void populateArchetypes() 
    {
        archetypes.add(new CharacterArchetype('A', 
            " XXX " +
            "X   X" +
            "XXXXX" +
            "X   X" +
            "X   X"
        ));
        archetypes.add(new CharacterArchetype('B', 
            "XXXX " +
            "X   X" +
            "XXXX " +
            "X   X" +
            "XXXX "
        ));
        archetypes.add(new CharacterArchetype('C', 
            " XXXX" +
            "X    " +
            "X    " +
            "X    " +
            " XXXX"
        ));
        archetypes.add(new CharacterArchetype('D', 
            "XXXX " +
            "X   X" +
            "X   X" +
            "X   X" +
            "XXXX "
        ));
        archetypes.add(new CharacterArchetype('E', 
            "XXXXX" +
            "X    " +
            "XXXXX" +
            "X    " +
            "XXXXX"
        ));
        archetypes.add(new CharacterArchetype('F', 
            "XXXXX" +
            "X    " +
            "XXXXX" +
            "X    " +
            "X    "
        ));
        archetypes.add(new CharacterArchetype('G', 
            " XXX " +
            "X    " +
            "X  XX" +
            "X   X" +
            " XXX "
        ));
        archetypes.add(new CharacterArchetype('H', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('I', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('J', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('K', 
            "X   X" +
            "X  X " +
            "XXX  " +
            "X  X " +
            "X   X"
        ));
        archetypes.add(new CharacterArchetype('L', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('M', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('N', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('O', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('P', 
            "XXXX " +
            "X   X" +
            "XXXX " +
            "X    " +
            "X    "
        ));
        archetypes.add(new CharacterArchetype('Q', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('R', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('S', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('T', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('U', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('V', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('W', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('X', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('Y', 
            "     " +
            "     " +
            "     " +
            "     " +
            "     "
        ));
        archetypes.add(new CharacterArchetype('Z', 
            "XXXXX" +
            "   X " +
            "  X  " +
            " X   " +
            "XXXXX"
        ));
    }


}
