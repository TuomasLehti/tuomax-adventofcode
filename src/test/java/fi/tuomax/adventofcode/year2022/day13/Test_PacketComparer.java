package fi.tuomax.adventofcode.year2022.day13;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Test_PacketComparer {

    @Test
    public void testTri_Simple()
    {
        final String LOWER = "[1, 2, 3]";
        final String HIGHER = "[4, 5, 6]";
        assertEquals(TrinaryBoolean.TRUE, PacketComparer.inOrder(LOWER, HIGHER));
        assertEquals(TrinaryBoolean.FALSE, PacketComparer.inOrder(HIGHER, LOWER));
        assertEquals(TrinaryBoolean.UNDECIDABLE, PacketComparer.inOrder(LOWER, LOWER));
    }

    @Test
    public void testTri_DifferentLengths()
    {
        final String SHORTER = "[1, 2, 3]";
        final String LONGER = "[1, 2, 3, 4, 5, 6]";
        assertEquals(TrinaryBoolean.TRUE, PacketComparer.inOrder(SHORTER, LONGER));
        assertEquals(TrinaryBoolean.FALSE, PacketComparer.inOrder(LONGER, SHORTER));
    }

    @Test
    public void testTri_SubArray()
    {
        final String LOWER = "[1, 2, [3, 4, 5]]";
        final String HIGHER = "[1, 2, [6, 7, 8]]";
        assertEquals(TrinaryBoolean.TRUE, PacketComparer.inOrder(LOWER, HIGHER));
        assertEquals(TrinaryBoolean.FALSE, PacketComparer.inOrder(HIGHER, LOWER));
        assertEquals(TrinaryBoolean.UNDECIDABLE, PacketComparer.inOrder(LOWER, LOWER));
    }

    @Test
    public void testTri_UndecidableSubArray()
    {
        final String LOWER = "[1, 2, [3, 4, 5], 6]";
        final String HIGHER = "[1, 2, [3, 4, 5], 7]";
        assertEquals(TrinaryBoolean.TRUE, PacketComparer.inOrder(LOWER, HIGHER));
        assertEquals(TrinaryBoolean.FALSE, PacketComparer.inOrder(HIGHER, LOWER));
        assertEquals(TrinaryBoolean.UNDECIDABLE, PacketComparer.inOrder(LOWER, LOWER));
    }

}
