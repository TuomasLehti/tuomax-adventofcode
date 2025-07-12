package fi.tuomax.adventofcode.year2017.day23;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;

public class Test_CoprocessorConflagration
extends PuzzleTester
{

    @Test
    public void test_Part1()
    {
        runTests(new CoprocessorConflagration_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new CoprocessorConflagration_Part2());
    }


    @Test
    public void test_reverseEngineered()
    {
        long a = 0;
        long b = 0;
        long c = 0;
        long d = 0;
        long e = 0;
        long f = 0;
        long g = 0;
        long h = 0;
        long mc = 0;
        long innestLoops = 0;
        long innerLoops = 0;

        b = 81;
        c = b;
        if (a != 0)
        {
            b *= 100;
            b += 100_000;  // b = 108_100
            c = b;
            c += 17_000; // c = 125_100
        }
        while (true) {
            f = 1;
            d = 2;
            do {
                e = 2;
                System.out.println(d);
                do {
                    g = d * e - b;
//                    System.out.print(g + " ");
                    mc++;
                    if (g == 0)
                    {
                        f = 0;
                        System.out.println(d + " " + e);
                    }
                    e += 1;                      
                    g = e - b;
//                    System.out.println(g + " " + e);
                    innestLoops++;
                } while (g != 0);
                innestLoops = 0;
                innerLoops++;
                d += 1;
                g = d - b;
            } while (g != 0);
            if (f != 0) {
                h += 1;
            }
            g = b - c;
            System.out.println(g);
            if (g == 0) 
                break;
            b += 17;
        }
    System.out.println(mc);
    System.out.print("");
    }
    @Test

    public void test_reverseEngineered_looped()
    {
        long a = 0;
        long b = 0;
        long c = 0;
//        long d = 0;
//        long e = 0;
        long f = 0;
        long g = 0;
        long h = 0;
        long mc = 0;
        long innestLoops = 0;
        long innerLoops = 0;

        b = 81;
        c = b;
        if (a != 0)
        {
            b *= 100;
            b += 100_000;  // b = 108_100
            c = b;
            c += 17_000; // c = 125_100
        }
        while (true) {
            f = 1;
            for (long d = 2; d < b; d++) {
                System.out.println(d);
                for (long e = 2; e < b; e++) {
                    g = d * e - b;
//                    System.out.print(g + " ");
                    mc++;
                    if (g == 0)
                    {
                        f = 0;
                        h += 1;
                    }
                    g = e - b;
//                    System.out.println(g + " " + e);
                    innestLoops++;
                }
                innestLoops = 0;
                innerLoops++;
                g = d - b;
            };
//            if (f != 0) {
//                h += 1;
//            }
            g = b - c;
            System.out.println(g);
            if (g == 0) 
                break;
            b += 17;
        }
    System.out.println(mc);
    System.out.print("");
    }

    @Test
    public void test_reverseEngineered_andOptimized()
    {
        long a = 1;
        long b = 0;
        long c = 0;
        long d = 0;
        long e = 0;
        boolean f = true; // 0 = true, 1 = false
        long g = 0;
        long h = 0;
        long mc = 0;
        long innestLoops = 0;
        long innerLoops = 0;

        b = 81;
        c = b;
        if (a != 0)
        {
            b *= 100;
            b += 100_000;  // b = 108_100
            c = b;
            c += 17_000; // c = 125_100
        }
        while (true) {
            f = false;
            d = 2;
            do {
                e = 2;
                f = ((g % d) == 0);
                d += 1;
                g = d - b;
            } while (g != 0);
            if (!f) {
                h += 1;
            }
            g = b - c;
            System.out.println(g);
            if (g == 0) 
                break;
            b += 17;
        }
    System.out.println(h);
    System.out.print("");
    }

    @Test
    public void test_java()
    {
        long b = 81;
        long c = 81;
        long ans = 0;

        for (long i = 0; i < (b - 2); i++) {

        }

    System.out.println(ans);
    System.out.print("");
    }

    private boolean isPrime(long num)
    {
        for (long factor = 2; factor < num; factor++)
            if (num % factor == 0) return false;
        return true;
    }

    @Test
    public void test_prime()
    {
        long ans = 0;
        for (long num = 108_100; num <= 125_100; num += 17) 
            if (!isPrime(num)) ans++;
        System.out.println(ans);
        System.out.println ();
    }

}
// 1001 too high
// 1000 too high