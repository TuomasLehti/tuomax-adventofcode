package fi.tuomax.adventofcode.year2015.day22.players;

import fi.tuomax.adventofcode.year2015.day22.GameObject;

/**
 * A base class for a player in Aoc RPG Simulator includes the common 
 * properties and methods of the hero and the boss.
 */
public abstract class Player 
extends GameObject
{

    /** The number of hit points this player has. */
    private Integer hitPoints;

    /**
     * Returns the number of hit points this player has.
     * @return
     *      The number of hit points this player has.
     */
    public Integer getHitPoints() 
    {
        return hitPoints;
    }

    /**
     * Sets the amount of hit points this player has.
     * @param hitPoints
     *      The new amount of hit points.
     */
    protected void setHitPoints(Integer hitPoints) 
    {
        this.hitPoints = hitPoints;
    }

    /**
     * Creates a player.
     * @param hitPoints
     *      The number of hit points this player has.
     */
    public Player(Integer hitPoints)
    {
        this.hitPoints = hitPoints;
    }

    /**
     * This player is hit.
     * @param damage
     *      The damage incurred from this blow.
     */
    public void getsHit(int damage) 
    {
        setHitPoints(getHitPoints() - damage);
    }

    /**
     * Determines if a player is dead.
     * @return
     *      True if player is dead.
     */
    public Boolean isDead()
    {
        return hitPoints <= 0;
    }

}
