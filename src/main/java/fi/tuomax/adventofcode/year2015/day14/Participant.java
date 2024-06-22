package fi.tuomax.adventofcode.year2015.day14;

/**
 * A representation of a reindeer participating in a race for part 2 of Advent
 * of Code 2015, day 14.
 */
public class Participant 
implements Comparable<Participant>
{

    private Reindeer reindeer;

    private Integer score = 0;

    /**
     * The distance travelled in the latest race, which must be stored, because
     * participants are sorted by this value.
     */
    private Integer distance = 0;

    public Integer getDistance() 
    {
        return distance;
    }

    public Participant(Reindeer reindeer)
    {
        this.reindeer = reindeer;
    }

    /**
     * The puzzle talks about a single race lasting however many seconds.
     * In this implementation the race is split up to steps, duration of each
     * is one second, and the order of reindeer is assessed each time in order
     * to award points.
     */
    public void step(Integer howlong)
    {
        distance = reindeer.distance(howlong);
    }

    public Integer getScore() 
    {
        return score;
    }

    public void awardPoint() 
    {
        score++;
    }

    @Override
    public int compareTo(Participant o) 
    {
        return o.distance - this.distance;
    }

    @Override
    public String toString()
    {
        return String.format(
            "%s % 5d % 5d | ", 
            reindeer.getName(), 
            distance, 
            score);
    }


}
