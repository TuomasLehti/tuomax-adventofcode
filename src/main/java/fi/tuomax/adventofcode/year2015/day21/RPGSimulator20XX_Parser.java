package fi.tuomax.adventofcode.year2015.day21;

import java.util.ArrayList;
import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * Parses Aoc input for year 2015, day 21.<p>
 * 
 * The first lines of the input are from the input which Aoc gives.
 * After that the items in the shop should be added.<p>
 * 
 * {@snippet :
 * Hit Points: xxx
 * Damage: x
 * Armor: x
 * 
 * Weapons:    Cost  Damage  Armor
 * Dagger        8     4       0
 * ... rest of weapons ...
 * 
 * Armor:      Cost  Damage  Armor
 * ... armors ...
 * 
 * Rings:      Cost  Damage  Armor
 * ... rings ...
 * }
 */
public class RPGSimulator20XX_Parser 
extends Parser
{

    public RPGSimulator20XX_Parser(List<String> input) 
    {
        super(input);
    }

    /**
     * Opponent's hit points.
     */
    Integer hitPoints;

    /**
     * Opponent's damage.
     */
    Integer damage;

    /**
     * Opponent's armor.
     */
    Integer armor;

    /**
     * The opponent described in this input.
     */
    Player opponent;

    /**
     * Returns the opponent described in this input.
     * @return
     *      The opponent.
     */
    public Player getOpponent() {
        return opponent;
    }

    /**
     * Available weapons.
     */
    private List<Weapon> damageWeapons = new ArrayList<>();

    /**
     * Available armors.
     */
    private List<Weapon> armorWeapons = new ArrayList<>();

    /**
     * Available rings.
     */
    private List<Weapon> rings = new ArrayList<>();

    /** The shop selling the weapons. */
    private Shop shop;

    /**
     * Returns the shop selling the weapons.
     * @return
     *      The shop selling the weapons.
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * States of parsing.
     */
    private enum State 
    {
        /** Reading opponent's values. */
        OPPONENT,
        /** Reading weapons. */
        DAMAGE,
        /** Reading armors. */
        ARMOR,
        /** Reading rings. */
        RINGS
    }

    /**
     * State of parsing.
     */
    private State state = State.OPPONENT;

    protected void parseLine(String token) 
    {
        if (token.isEmpty()) return;
        if (token.contains("Cost")) {
            if (token.startsWith("Weapons:")) {
                state = State.DAMAGE;
                return;
            }
            if (token.startsWith("Armor:")) {
                state = State.ARMOR;
                return;
            }
            if (token.startsWith("Rings:")) {
                state = State.RINGS;
                return;
            }
        }
        switch (state) {
            case OPPONENT :
                parseOpponent(token);
                break;
            case ARMOR:
                armorWeapons.add(parseWeapon(token));
                break;
            case DAMAGE:
                damageWeapons.add(parseWeapon(token));
                break;
            case RINGS:
                rings.add(parseWeapon(token));
                break;
            default:
                break;
        }
                
    }

    private void parseOpponent(String token) {
        if (token.startsWith("Hit Points"))
            hitPoints = Integer.valueOf(
                token.substring(token.indexOf(":") + 2));
        if (token.startsWith("Damage"))
            damage = Integer.valueOf(
                token.substring(token.indexOf(":") + 2));
        if (token.startsWith("Armor"))
            armor = Integer.valueOf(
                token.substring(token.indexOf(":") + 2));
    }

    private Weapon parseWeapon(String token)
    {
        return Weapon.fromString(token);
    }

    @Override
    public void parse() {
        for (String line : input)
            parseLine(line);
        opponent = new Player(hitPoints, damage, armor);
        shop = new Shop(damageWeapons, armorWeapons, rings);
    }
 
}
