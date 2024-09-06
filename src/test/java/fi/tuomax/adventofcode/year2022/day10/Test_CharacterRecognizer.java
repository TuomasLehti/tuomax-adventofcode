package fi.tuomax.adventofcode.year2022.day10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_CharacterRecognizer 
{

    @Test
    public void test()
    {
        final String INPUT =
"X  X" +
"X X " +
"XX  " +
"X X " +
"X X " +
"X  X" ;
        assertEquals('K', (char) CharacterRecognizer.recognize(INPUT, 4, 6));
    }
    

/*
###..####..##..###..#..#.###..####.###..
#..#....#.#..#.#..#.#.#..#..#.#....#..#.
#..#...#..#....#..#.##...#..#.###..###..
###...#...#.##.###..#.#..###..#....#..#.
#....#....#..#.#....#.#..#....#....#..#.
#....####..###.#....#..#.#....####.###..

#..#
#.#.
##..
#.#.
#.#.
#..#


*/    
}
