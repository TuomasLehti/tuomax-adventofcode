package fi.tuomax.adventofcode.year2022.day13;

import org.json.JSONArray;

/**
 * Defines if two packets are in the right order.
 */
public class PacketComparer {

    public static TrinaryBoolean inOrder(String left, String right)
    {
        return inOrder(new JSONArray(left), new JSONArray(right));
    }

    public static TrinaryBoolean inOrder(JSONArray one, JSONArray other)
    {
        int longerLength = Math.max(one.length(), other.length());
        for (int i = 0; i < longerLength; i++) {

            /* One of arrays is shorter than the other. */
            if (i == one.length()) return TrinaryBoolean.TRUE;
            if (i == other.length()) return TrinaryBoolean.FALSE;

            /* Try getting integers. */
            int left = one.optInt(i, -1);
            int right = other.optInt(i, -1);

            /* Both are ints, compare straight up. */
            if (left > -1 && right > -1)
                if (left > right) 
                    return TrinaryBoolean.FALSE;
                else if (left < right)
                    return TrinaryBoolean.TRUE;
                else 
                    continue;

            /* Convert both to arrays if they aren't already. */
            JSONArray leftArr = 
                left == -1 ? 
                one.getJSONArray(i) : 
                new JSONArray(String.format("[%d]", left));

            JSONArray rightArr = 
                right == -1 ? 
                other.getJSONArray(i) : 
                new JSONArray(String.format("[%d]", right));

            TrinaryBoolean subResult = inOrder(leftArr, rightArr);
            if (subResult != TrinaryBoolean.UNDECIDABLE)
                return subResult;
            /* else continue; */
        }
        return TrinaryBoolean.UNDECIDABLE;
    }

}
