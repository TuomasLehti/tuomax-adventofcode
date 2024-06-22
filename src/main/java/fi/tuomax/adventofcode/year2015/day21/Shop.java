package fi.tuomax.adventofcode.year2015.day21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This shop sells weapons for players in the AoC RPG Simulator. It can be 
 * iterated, which yields combinations of weapons.
 */
public class Shop 
implements Iterable<Set<Weapon>>
{

    /**
     * Creates the shop.
     * @param weapons
     *      List of available weapons.
     * @param armors
     *      List of available armors.
     * @param rings
     *      List of available rings.
     */
    public Shop(
        List<Weapon> weapons, 
        List<Weapon> armors, 
        List<Weapon> rings
    ) {
        this.weapons = weapons;
        this.armors = armors;
        this.rings = rings;
        combinate();
    }

    /**
     * Calculates the price of a combination of weapons.
     * @param combination
     *      The combination of weapons.
     * @return
     *      The price.
     */
    public Integer price(Set<Weapon> combination)
    {
        Integer price = 0;
        for (Weapon weapon : combination) {
            price += weapon.price();
        }
        return price;
    }

    /** List of available weapons. */
    private List<Weapon> weapons;

    /** List of available armors. */
    private List<Weapon> armors;

    /** List of available rings. */
    private List<Weapon> rings;

    /** Available combinations of weapons. */
    private List<Set<Weapon>> combinations = new ArrayList<>();

    /**
     * Makes all the allowed combinations of the available weapons, armors and 
     * rings. See the puzzle for rules.
     */
    private void combinate() 
    {
        /* Player should buy exactly one weapon. */
        for (int w = 0; w < weapons.size(); w++) {
            /* Armor is optional, one allowed. */
            for (int a = -1; a < weapons.size(); a++) {
                /* 0-2 rings allowed. */
                for (int r1 = -1; r1 < rings.size(); r1++) {
                    for (int r2 = r1; r2 < rings.size(); r2++) {
                        Set<Weapon> chosen = new HashSet<Weapon>();
                        chosen.add(weapons.get(w));
                        if (a > -1)
                            chosen.add(armors.get(a));
                        /* It's a set, a ring doesn't get added twice. */
                        if (r2 > -1) 
                            chosen.add(rings.get(r2));
                        if (r1 > -1) 
                            chosen.add(rings.get(r1));
                        combinations.add(chosen);
                    }
                }
            }
        }
    }

    /** Shop iterates over sets of weapons. */
    @Override
    public Iterator<Set<Weapon>> iterator() 
    {
        return combinations.iterator();
    }
    
}
