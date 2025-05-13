package fi.tuomax.adventofcode.parsing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.framework.parsing.IntegerListParser;

public class TestIntegerListParser 
{

    private final List<String> TEST_LIST = Arrays.asList(
        new String[]{"13", "-21", "-0"}
    );

    private final List<Integer> EXPECTED = Arrays.asList(
        new Integer[]{13, -21, 0}
    );

    @Test
    public void test_MultiLine()
    {
        IntegerListParser parser = new IntegerListParser(TEST_LIST);
        parser.parse();
        assertEquals(EXPECTED, parser.getIntegers());
    }

    @Test
    public void test_SingleLine()
    {
        List<String> input = new ArrayList<>();
        input.add(String.join(",", TEST_LIST));
        IntegerListParser parser = new IntegerListParser(input, ",");
        parser.parse();
        assertEquals(EXPECTED, parser.getIntegers());
    }

}
