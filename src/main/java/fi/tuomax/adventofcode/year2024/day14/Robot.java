package fi.tuomax.adventofcode.year2024.day14;

import fi.tuomax.adventofcode.commons.Coordinates;

public class Robot 
{

    public static Integer spaceWidth = 1;
    public static Integer spaceHeight = 1;

    private Coordinates position;
    
    public Coordinates getPosition() 
    {
        return position;
    }

    private Coordinates velocity;

    public Robot(String aocInput)
    {
        String[] parts = aocInput.split("p=| v=|,| ");
        position = new Coordinates(
            Long.valueOf(parts[1]), 
            Long.valueOf(parts[2])
        );
        velocity = new Coordinates(
            Long.valueOf(parts[3]), 
            Long.valueOf(parts[4])
        );
    }

    public void step(int numOfSteps) 
    {
        Coordinates vector = new Coordinates(
            velocity.x() * numOfSteps, 
            velocity.y() * numOfSteps
        );
        Coordinates newPosition = position.translate(vector);
        position = new Coordinates(
            (newPosition.x() + numOfSteps * spaceWidth) % spaceWidth,
            (newPosition.y() + numOfSteps * spaceHeight) % spaceHeight
        );
    }
    
}
