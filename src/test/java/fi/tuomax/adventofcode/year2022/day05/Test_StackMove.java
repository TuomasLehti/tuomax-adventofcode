package fi.tuomax.adventofcode.year2022.day05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_StackMove 
{

    @Test
    public void test_StackMove()
    {
        final Integer EXPECTED_AMOUNT = 13;
        final Integer EXPECTED_FROM = 10;
        final Integer EXPECTED_TO = 76;
        StackMove move = StackMove.fromInput(String.format(
            "move %d from %d to %d",
            EXPECTED_AMOUNT, EXPECTED_FROM, EXPECTED_TO
        ));
        assertEquals(EXPECTED_AMOUNT, move.amount());
        assertEquals(EXPECTED_FROM, move.from());
        assertEquals(EXPECTED_TO, move.to());
    }
    
}
