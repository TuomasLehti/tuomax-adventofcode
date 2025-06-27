package fi.tuomax.adventofcode.year2017.day20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.commons.Coordinates3d;

public class Test_ParticleSwarm
extends PuzzleTester
{

    @Test
    public void test_Particle_Creation()
    {
        Particle particle = Particle.fromAocInput("p=<3,0,0>, v=<2,0,0>, a=<-1,0,0>");
        assertEquals(
            new Particle(
                new Coordinates3d(3L, 0L, 0L),
                new Coordinates3d(2L, 0L, 0L),
                new Coordinates3d(-1L, 0L, 0L)
            ),
            particle
        );
    }

    @Test
    public void test_Part1()
    {
        runTests(new ParticleSwarm_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new ParticleSwarm_Part2());
    }

}
