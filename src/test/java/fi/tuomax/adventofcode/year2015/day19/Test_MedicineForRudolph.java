package fi.tuomax.adventofcode.year2015.day19;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class Test_MedicineForRudolph 
{

    @Test
    public void test_Hoh()
    {
        test(
            MedicineForRudolph_Part1.class, 
            "test hoh.txt", 
            "4"
        );
    }

    @Test
    public void test_Hohoho()
    {
        test(
            MedicineForRudolph_Part1.class, 
            "test hohoho.txt", 
            "7"
        );
    }

    public void test(Class<? extends Solver> clazz, String filename, String expectedAnswer) 
    {
        try {
            Solver solver = clazz.getConstructor().newInstance();
            solver.run(InputFactory.inputFromMetadata(solver.getMetadata(), filename));
            assertEquals(expectedAnswer, solver.getAnswer());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
    
}
