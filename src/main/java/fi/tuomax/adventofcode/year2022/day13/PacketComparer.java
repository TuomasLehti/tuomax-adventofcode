package fi.tuomax.adventofcode.year2022.day13;

import org.json.JSONArray;

/**
 * Defines if two packets are in the right order.
 */
public class PacketComparer {

    public static Boolean compare(JSONArray one, JSONArray other)
    {
        int longerLength = Math.max(one.length(), other.length());
        for (int i = 0; i < longerLength; i++) {
            
            if (i == one.length()) return true;
            if (i == other.length()) return false;
            
            int left = one.optInt(i, -1);
            int right = other.optInt(i, -1);

            /* Both are ints, compare straight up. */
            if (left > -1 && right > -1)
                if (left > right) 
                    return false;
                else
                    continue;

            /* Different types. Make both arrays. */
            JSONArray leftArr = 
                left == -1 ? 
                one.getJSONArray(i) : 
                new JSONArray(String.format("[%d]", left));

            JSONArray rightArr = 
                right == -1 ? 
                other.getJSONArray(i) : 
                new JSONArray(String.format("[%d]", right));

            /* Now they're both arrays. */
            if (areEqual(leftArr, rightArr))
                continue;
            else
                return compare(leftArr, rightArr);
            
        }
        return true;
    }

    public static Boolean areEqual(JSONArray one, JSONArray other)
    {
        if (one.length() != other.length()) return false;
        for (int i = 0; i < one.length(); i++)
            if (one.getInt(i) != other.getInt(i)) return false;
        return true;
    }
    
}
