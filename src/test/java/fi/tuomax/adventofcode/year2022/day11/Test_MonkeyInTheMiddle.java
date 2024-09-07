package fi.tuomax.adventofcode.year2022.day11;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;

public class Test_MonkeyInTheMiddle
extends PuzzleTester
{

    @Test
    public void test_Part1()
    {
        runTests(new MonkeyInTheMiddle_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new MonkeyInTheMiddle_Part2());
    }

    @Test
    public void test_Divisibility()
    {
        int[] divisors = new int[]{13, 17, 19, 23};
        int divisorProduct = 1;
        for (int divisor : divisors) divisorProduct *= divisor;

        for (int i = 0; i < divisorProduct; i++) {
            int[] lower = new int[]{
                i % divisors[0],
                i % divisors[1],
                i % divisors[2],
                i % divisors[3]
            };
            int[] higher = new int[]{
                (i + divisorProduct) % divisors[0],
                (i + divisorProduct) % divisors[1],
                (i + divisorProduct) % divisors[2],
                (i + divisorProduct) % divisors[3]
            };
            if (
                lower[0] != higher[0] &&
                lower[1] != higher[1] &&
                lower[2] != higher[2] &&
                lower[3] != higher[3] /*||
                (i % 1000) == 0*/
            ) {
                System.out.println(
                    i + ": " +
                    lower[0] + " " +
                    lower[1] + " " +
                    lower[2] + " " +
                    lower[3] + " - " +
                    higher[0] + " " +
                    higher[1] + " " +
                    higher[2] + " " +
                    higher[3] + " "
                );
            }
        }
    }

}
