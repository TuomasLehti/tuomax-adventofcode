package fi.tuomax.adventofcode.year2017.day20;

import fi.tuomax.adventofcode.commons.Coordinates3d;

public class Particle {

    private Coordinates3d position;
    
    private Coordinates3d velocity;
    
    private Coordinates3d acceleration;

    public Coordinates3d getAcceleration() 
    {
        return acceleration;
    }

    public Particle(Coordinates3d position, Coordinates3d velocity, Coordinates3d acceleration)
    {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
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
