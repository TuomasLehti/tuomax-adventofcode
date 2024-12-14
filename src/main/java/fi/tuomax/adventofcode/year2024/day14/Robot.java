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

    public Boolean isMirrorOf(Robot other)
    {
        /* If they're on different rows, return false. */
        if (!this.getPosition().y().equals(other.getPosition().y()))
            return false;

        long middle = Robot.spaceWidth / 2;
        long onesDistFromMiddle = this.getPosition().x() - middle;

        /* If a robot is at the middle, it is always a mirror of itself. */
        if (onesDistFromMiddle == 0) return true;

        long othersDistFromMiddle = other.getPosition().x() - middle;

        /* They are mirrored if their distance from the middle is the same, but
         * their sign is different.
         * 
         * This uses a trick with compiler. The second comparison, after the 
         * and, is only evaluated if the absolute values of the distances are
         * the same, which means that the distances are (d,d), (d,-d), (-d,d)
         * or (-d,-d).
         * 
         * In the second comparison the signs of the distances are same if the 
         * distances are same!
         */
        return 
            Math.abs(onesDistFromMiddle) == Math.abs(othersDistFromMiddle) &&
            onesDistFromMiddle != othersDistFromMiddle;
    }
    
}
