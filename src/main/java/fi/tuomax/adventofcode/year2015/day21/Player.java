package fi.tuomax.adventofcode.year2015.day21;

import java.util.Set;

/**
 * A player in Aoc RPG Simulator.
 */
public class Player 
{

    /**
     * The number of hit points this player has.
     */
    private Integer hitPoints;

    /**
     * The damage this player does per turn. It includes the damage from all
     * the weapons a player has.
     */
    private Integer damage;

    /**
     * The strength of armor his player has. It includes the strength from all
     * the armor this a has.
     */
    private Integer armor;

    /**
     * Returns the number of hit points this player has.
     * @return
     *      The number of hit points this player has.
     */
    public Integer getHitPoints() {
        return hitPoints;
    }

    /**
     * Returns the damage this player does per turn.
     * @return
     *      The amount of damage this player does per turn.
     */
    public Integer getDamage() {
        return damage;
    }

    /**
     * Returns the strength of armor this player has.
     * @return
     *      The strength of armor this player has.
     */
    public Integer getArmor() {
        return armor;
    }

    /**
     * Creates a player.
     * @param hitPoints
     *      The number of hit points this player has.
     * @param damage
     *      The amount of damage this player does per turn. It should include
     *      the damage of all the weapons this player has.
     * @param armor
     *      The strength of armor this player has. It should include all the
     *      armor this player has.
     */
    public Player(Integer hitPoints, Integer damage, Integer armor)
    {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.armor = armor;
    }

    /**
     * Creates a player.
     * @param hitPoints
     *      The number of hit points this player has.
     * @param weapons
     *      The weapons chosen by this player.
     */
    public Player(Integer hitPoints, Set<Weapon> weapons)
    {
        this.hitPoints = hitPoints;
        damage = 0;
        armor = 0;
        for (Weapon weapon : weapons) {
            damage += weapon.damage();
            armor += weapon.armor();
        }
    }

    /**
     * Determines if this player wins an opponent.
     * @param other
     *      The opponent.
     * @return
     *      True if this player is victorius.
     */
    public Boolean wins(Player other)
    {
        Integer myHpLossPerTurn = other.getDamage() - getArmor();
        Integer oppHpLossPerTurn = getDamage() - other.getArmor();

        if (myHpLossPerTurn < 1)
            myHpLossPerTurn = 1;
        if (oppHpLossPerTurn < 1)
            oppHpLossPerTurn = 1;

        Integer turnsToMyDefeat = (getHitPoints() / myHpLossPerTurn);
        Integer turnsToOppsDefeat = (other.getHitPoints() / oppHpLossPerTurn);
        return turnsToMyDefeat >= turnsToOppsDefeat;
    }

}
