package fi.tuomax.adventofcode.year2017.day10;

import org.junit.Test;

public class Test_KnotHasher 
{

    @Test
    public void test()
    {
        KnotHasher hasher = new KnotHasher(5);
        System.out.println(hasher.toString());
        hasher.run(3);
        System.out.println(hasher.toString());
        hasher.run(4);
        System.out.println(hasher.toString());
        hasher.run(1);
        System.out.println(hasher.toString());
        hasher.run(5);
        System.out.println(hasher.toString());
    }
    
}
