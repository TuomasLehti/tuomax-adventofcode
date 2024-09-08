package fi.tuomax.adventofcode.year2022.day13;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONArray;
import org.junit.Test;

public class Test_PacketComparer {

    @Test
    public void test_RightOrder()
    {
        JSONArray one = new JSONArray("[0, 1]");
        JSONArray other = new JSONArray("[2, 3]");
        assertTrue(PacketComparer.compare(one, other));
    }

    @Test
    public void test_WrongOrder()
    {
        JSONArray one = new JSONArray("[0, 1]");
        JSONArray other = new JSONArray("[2, 3]");
        assertFalse(PacketComparer.compare(other, one));
    }

    @Test
    public void test_DifferentLengths_RightOrder()
    {
        JSONArray one = new JSONArray("[0, 1]");
        JSONArray other = new JSONArray("[2, 3, 4, 5]");
        assertTrue(PacketComparer.compare(one, other));
    }

    @Test
    public void test_DifferentLengths_WrongOrder()
    {
        JSONArray one = new JSONArray("[0, 1, 2, 3]");
        JSONArray other = new JSONArray("[2, 3]");
        assertFalse(PacketComparer.compare(one, other));
    }

    @Test
    public void test_SubArray_Right()
    {
        JSONArray one = new JSONArray("[0, [1, 2, 3], 4]");
        JSONArray other = new JSONArray("[0, [5, 6, 7], 4]");
        assertTrue(PacketComparer.compare(one, other));
    }

    @Test
    public void test_SubArray_Wrong()
    {
        JSONArray one = new JSONArray("[0, [1, 2, 3], 4]");
        JSONArray other = new JSONArray("[0, [5, 6, 7], 4]");
        assertFalse(PacketComparer.compare(other, one));
    }

    @Test
    public void test_SubArray_Equal()
    {
        JSONArray one = new JSONArray("[0, [1, 2, 3], 4]");
        JSONArray other = new JSONArray("[0, [1, 2, 3], 5]");
        assertTrue(PacketComparer.compare(one, other));
    }

    @Test
    public void test_DifferentTypes_Right()
    {
        JSONArray one = new JSONArray("[0, 1, 2]");
        JSONArray other = new JSONArray("[0, [2], 2]");
        assertTrue(PacketComparer.compare(one, other));
        assertFalse(PacketComparer.compare(other, one));
    }

    @Test
    public void test_Different_Types_Equal()
    {
        JSONArray one = new JSONArray("[0, 1, 2]");
        JSONArray other = new JSONArray("[0, [1], 3]");
        assertTrue(PacketComparer.compare(one, other));
    }

    @Test
    public void test_AreEqual()
    {
        assertTrue(PacketComparer.areEqual(
            new JSONArray("[0, 1, 2]"), 
            new JSONArray("[0, 1, 2]")
        ));
        assertFalse(PacketComparer.areEqual(
            new JSONArray("[0, 1, 2]"), 
            new JSONArray("[3, 4, 5]")
        ));
        assertFalse(PacketComparer.areEqual(
            new JSONArray("[0, 1, 2]"),
            new JSONArray("[3, 4, 5]")
        ));
        assertTrue(PacketComparer.areEqual(
            new JSONArray("[]"),
            new JSONArray("[]")
        ));
        assertFalse(PacketComparer.areEqual(
            new JSONArray("[1]"),
            new JSONArray("[]")
        ));
    }


}
