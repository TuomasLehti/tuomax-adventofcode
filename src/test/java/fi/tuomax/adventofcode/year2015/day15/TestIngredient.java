package fi.tuomax.adventofcode.year2015.day15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class TestIngredient 
{

    @Test
    public void testFromInput()
    {
        try {
            List<String> input = InputFactory.inputFromMetadata(
                new Metadata(2015, 15, null, null, null), 
                "test.txt"
            );
            Ingredient ingredient = Ingredient.fromInput(input.get(0));
            assertEquals(-1L, (long) ingredient.capacity());
            assertEquals(-2L, (long) ingredient.durability());
            assertEquals(6L, (long) ingredient.flavor());
            assertEquals(3L, (long) ingredient.texture());
            assertEquals(8L, (long) ingredient.calories());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testPart1()
    {
        try {
            ScienceForHungryPeople_Part1 part = new ScienceForHungryPeople_Part1();
            part.run(InputFactory.inputFromMetadata(part.getMetadata(), "test.txt"));
            assertEquals("62842880", part.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testPart2()
    {
        try {
            ScienceForHungryPeople_Part2 part = new ScienceForHungryPeople_Part2();
            part.run(InputFactory.inputFromMetadata(part.getMetadata(), "test.txt"));
            assertEquals("57600000", part.getAnswer());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
    
}
