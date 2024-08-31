package fi.tuomax.adventofcode.year2022.day05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Deque;
import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.inputting.InputFactory;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_SupplyStacks 
extends PuzzleTester
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

    @Test
    public void test_Parser()
    {
        try {
            Metadata metadata = new Metadata(2022, 5, null, null, null);
            readJson(metadata, "expected stacks.json");
            List<String> expectedStacks = getStrings(json.optJSONArray("expected_stacks"));
            SupplyStacks_Parser parser = new SupplyStacks_Parser(InputFactory.inputFromMetadata(metadata, "test.txt"));
            parser.parse();
            List<Deque<Character>> stacks = parser.getStacks();
            for (int i = 0; i < expectedStacks.size(); i++) {
                StringBuilder sb = new StringBuilder();
                while (!stacks.get(i).isEmpty())
                    sb.append(stacks.get(i).removeFirst());
                assertEquals(expectedStacks.get(i), sb.toString());
            }
    
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    
}
