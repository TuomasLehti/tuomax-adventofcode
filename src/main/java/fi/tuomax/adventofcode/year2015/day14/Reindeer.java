package fi.tuomax.adventofcode.year2015.day14;

/**
 * Represents a reindeer from Advent of Code 2015, day 14.
 */
public class Reindeer 
{

    private Integer speed = -1;

    private Integer flyTime = -1;

    private Integer restTime = -1;

    private String name = "";

    public String getName() {
        return name;
    }

    private Reindeer(Integer speed, Integer flyTime, Integer restTime, String name)
    {
        this.speed = speed;
        this.flyTime = flyTime;
        this.restTime = restTime;
        this.name = name;
    }

    public static Reindeer fromInput(String input)
    {
        String[] parts = input.substring(0, input.length() - 1).split(" ");
        return new Reindeer(
            Integer.valueOf(parts[3]), 
            Integer.valueOf(parts[6]), 
            Integer.valueOf(parts[13]), 
            parts[0]);
    }

    /**
     * <p>Calculates the distance this reindeer flies in a given time. A cycle of 
     * a reindeer consists of a certain amount of flying and a certain amount
     * of resting. The distance travelled during a cycle is always the same, so
     * we can just calculate the number of whole cycles which have taken place
     * before this point in time, and times that by the distance of a single 
     * cycle.</p>
     * 
     * <p>The amount of seconds into the cycle going on at the given point in 
     * time can be determined by finding out the remainder of seconds. After n
     * seconds into the cycle the reindeer can be either flying or resting. If
     * it is flying, the distance travelled during the last cycle is the amount
     * of seconds times speed. If the reindeer is resting, we just times the 
     * speed with the time the reindeer flies in the beginning of the cycle.</p>
     */
    public Integer distance(Integer time)
    {
        Integer cycleTime = flyTime + restTime;
        Integer numOfCycles = time / cycleTime;
        Integer secondsRemaining = time % cycleTime;
        Integer distanceOfCycles = numOfCycles * speed * flyTime;
        Integer distanceOfRemainder = speed * Math.min(flyTime, secondsRemaining);
        return distanceOfCycles + distanceOfRemainder;
    }

}
