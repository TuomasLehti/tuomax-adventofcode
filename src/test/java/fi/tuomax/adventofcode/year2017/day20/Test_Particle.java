package fi.tuomax.adventofcode.year2017.day20;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fi.tuomax.adventofcode.commons.Coordinates3d;

public class Test_Particle 
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
    public void test_Collision()
    {
        Particle one = Particle.fromAocInput("p=<2,2,2>, v=<-1,-1,-1>, a=<-1,-1,-1>");
        Particle other = Particle.fromAocInput("p=<-2,-2,-2>, v=<1,1,1>, a=<1,1,1>");
        assertEquals(1f, (float) one.collidesWithAt(other), 0.0001f);
    }

    @Test
    public void test_KnownCollisionFromActualInput()
    {
        Particle one = Particle.fromAocInput("p=<-148,-1129,1285>, v=<18,132,-59>, a=<-1,-4,-12>");
        Particle other = Particle.fromAocInput("p=<-143,581,-450>, v=<34,-39,32>, a=<-4,-4,3>");
        assertEquals(10f, (float) one.collidesWithAt(other), 0.0001f);
    }
 


    

}
