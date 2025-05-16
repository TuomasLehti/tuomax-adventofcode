package fi.tuomax.adventofcode.year2017.day16;

public class CycleCalculator 
{


    /*
     * 0 a <- cycle start
     * 1 b
     * 2 c
     * 3 d
     * 4 e
     * 5 f
     * 6 a <- next cycle start
     * 7 b
     * 8 c
     * 9 d
     * 10 e
     * 11 f
     * 12 a
     * 13 b
     * 14 c
     * 15 d
     * 16 e
     * 17 f
     * 18 a
     * 19 b
     * 20 c
     * 21 d
     * 22 e
     * 23 f
     * 24 a
     * 25 b
     * 26 c <- target
     * 
     * cycle length = 6 - 0 = 6 = 
     *                next cycle start - cycle start
     * 
     * missing whole cycles = (26 - 6) div 6 = 3
     *              (target - next cycle start) div cycle length
     * 
     * start of last cycle = 6 + 3 * 6 = 24
     *              next cycle start + missing whole cycles * cycle length
     * 
     * last cycle remainder = 26 - 24 = 2
     *              target - start of last cycle
     * 
     */

    public static int indexOfTarget(
        int cycleStart,
        int nextCycleStart,
        long target
    ) {
        int cycleLength = nextCycleStart - cycleStart;
        long missingWholeCycles = (target - nextCycleStart) / cycleLength;
        long startOfLastCycle = nextCycleStart + missingWholeCycles * cycleLength;
        int lastCycleRemainder = (int) (target - startOfLastCycle);
        return lastCycleRemainder;
    }

}
