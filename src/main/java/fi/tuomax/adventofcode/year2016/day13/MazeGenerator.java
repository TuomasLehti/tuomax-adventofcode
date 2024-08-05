package fi.tuomax.adventofcode.year2016.day13;

import fi.tuomax.adventofcode.commons.Coordinates;

public class MazeGenerator 
{

    public static Integer favoriteNumber = 1350;

    public static Boolean isWall(Integer x, Integer y)
    {
        if (x < 0 || y < 0) return true;
        Integer number = (x * x + 3 * x + 2 * x * y + y + y * y) + favoriteNumber;
        char[] bits = Integer.toBinaryString(number).toCharArray();
        int sum = 0;
        for (char bit : bits)
            sum += bit - '0';
        return (sum % 2) == 1;
    }

    public static Boolean isWall(Coordinates coordinates)
    {
        return isWall(coordinates.xAsInt(), coordinates.yAsInt());
    }
    
}
