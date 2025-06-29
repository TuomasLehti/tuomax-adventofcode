package fi.tuomax.adventofcode.year2017.day20;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Coordinates3d;

public class Particle {

    private Coordinates3d position;
    
    public Coordinates3d getPosition() 
    {
        return position;
    }

    private Coordinates3d velocity;
    
    private Coordinates3d acceleration;

    public Coordinates3d getAcceleration() 
    {
        return acceleration;
    }

    /**
     * These represent the x-, y-, and z-coordinates over time.
     */
    private QuadraticEquation xEquation;
    private QuadraticEquation yEquation;
    private QuadraticEquation zEquation;

    protected QuadraticEquation getXEquation() 
    {
        return xEquation;
    }


    protected QuadraticEquation getYEquation() 
    {
        return yEquation;
    }


    protected QuadraticEquation getZEquation() 
    {
        return zEquation;
    }

    public Particle(Coordinates3d position, Coordinates3d velocity, Coordinates3d acceleration)
    {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;

        Coordinates3d[] positions = new Coordinates3d[]{
            position,
            
            position.translate(velocity.translate(acceleration)),
            
            position.translate(velocity.translate(acceleration))
                    .translate(velocity.translate(acceleration)
                                       .translate(acceleration))
        };
        xEquation = QuadraticEquation.fromThreePoints(new Long[]{
            positions[0].x(),
            positions[1].x(),
            positions[2].x()
        });
        yEquation = QuadraticEquation.fromThreePoints(new Long[]{
            positions[0].y(),
            positions[1].y(),
            positions[2].y()
        });
        zEquation = QuadraticEquation.fromThreePoints(new Long[]{
            positions[0].z(),
            positions[1].z(),
            positions[2].z()
        });
    }

    public static Particle fromAocInput(String input)
    {
        String[] parts = input.split(",|<|>");
        Coordinates3d position = Coordinates3d.fromIntegers(
            Integer.valueOf(parts[1]),
            Integer.valueOf(parts[2]),
            Integer.valueOf(parts[3])
        );
        Coordinates3d velocity = Coordinates3d.fromIntegers(
            Integer.valueOf(parts[6]),
            Integer.valueOf(parts[7]),
            Integer.valueOf(parts[8])
        );
        Coordinates3d acceleration = Coordinates3d.fromIntegers(
            Integer.valueOf(parts[11]),
            Integer.valueOf(parts[12]),
            Integer.valueOf(parts[13])
        );
        return new Particle(position, velocity, acceleration);
    }

    public Boolean collidesWith(Particle other)
    {
        return 
            xEquation.intersects(other.getXEquation()) &&
            yEquation.intersects(other.getYEquation()) &&
            zEquation.intersects(other.getZEquation());
    }

    /**
     * If there are two solutions, returns the smaller. If there are no solutions,
     * returns -1.
     * @param other
     * @return
     */
    public Float collidesWithAt(Particle other)
    {

        Set<Float> xSolutions = new QuadraticEquation(
            this.xEquation.getA() - other.xEquation.getA(),
            this.xEquation.getB() - other.xEquation.getB(),
            this.xEquation.getC() - other.xEquation.getC()
        ).getSolutions();
        
        Set<Float> ySolutions = new QuadraticEquation(
            this.yEquation.getA() - other.yEquation.getA(),
            this.yEquation.getB() - other.yEquation.getB(),
            this.yEquation.getC() - other.yEquation.getC()
        ).getSolutions();

        Set<Float> zSolutions = new QuadraticEquation(
            this.zEquation.getA() - other.zEquation.getA(),
            this.zEquation.getB() - other.zEquation.getB(),
            this.zEquation.getC() - other.zEquation.getC()
        ).getSolutions();

        xSolutions.retainAll(ySolutions);
        xSolutions.retainAll(zSolutions);
        xSolutions = positives(xSolutions);

        if (xSolutions.size() == 0) 
            return -1f;
        if (xSolutions.size() == 1)
            return (float) xSolutions.toArray()[0];
        return Math.min(
            (float) xSolutions.toArray()[0], 
            (float) xSolutions.toArray()[1]
        );
    }

    public Set<Float> positives(Set<Float> input)
    {
        Set<Float> result = new HashSet<>();
        for (Float f : input)
            if (f >= 0)
                result.add(f);
        return result;
    }
    
    public void tick()
    {
        velocity = velocity.translate(acceleration);
        position = position.translate(velocity);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (o == this) return true;
        if (!(o instanceof Particle)) return false;
        Particle other = (Particle) o;
        return 
            this.position.equals(other.position) &&
            this.velocity.equals(other.velocity) &&
            this.acceleration.equals(other.acceleration);
    }
    
}
