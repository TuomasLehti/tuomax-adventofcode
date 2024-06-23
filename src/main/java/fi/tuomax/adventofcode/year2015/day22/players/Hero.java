package fi.tuomax.adventofcode.year2015.day22.players;

import fi.tuomax.adventofcode.year2015.day22.spells.Shield;

public class Hero 
extends Player 
{

    /** The amount of mana this player has. */
    private Integer mana;

    private Shield shield;

    /** The total amount of mana spent by this player. */
    private Integer manaSpent = 0;

    /**
     * Returns the amount of mana this player has.
     * @return
     *      The amount of mana this player has.
     */
    public Integer getMana() 
    {
        return mana;
    }

    /**
     * Returns the total amount of mana spent by this player.
     * @return
     *      The amount of mana spent by this player.
     */
    public Integer getManaSpent() {
        return manaSpent;
    }

    /**
     * Creates a hero.
     * @param hitPoints
     *      The number of hit points this player has.
     * @param mana
     *      The amount of mana this player has.
     */
    public Hero(Integer hitPoints, Integer mana, Shield shield) {
        super(hitPoints);
        this.mana = mana;
        this.shield = shield;
    }

    @Override
    public void getsHit(int damage) {
        if (shield != null && shield.isEffecting()) {
            super.getsHit(damage - 7);
        } else {
            super.getsHit(damage);
        }
    }

    /**
     * Spends mana.
     * @param price
     *      The amount to spend.
     */
    public void spendMana(Integer price) {
        mana -= price;
        manaSpent += price;
    }
   
    public void manaRefill(Integer amount)
    {
        mana += amount;
    }

    public void heal(Integer healAmount)
    {
        setHitPoints(getHitPoints() + healAmount);
    }

    @Override
    public String saveState() {
        return String.join(",", new String[]{
            getHitPoints().toString(),
            getMana().toString(),
            getManaSpent().toString()
        });
    }

    @Override
    public void restoreState(String state) {
        String[] stateParts = state.split(",");
        setHitPoints(Integer.valueOf(stateParts[0]));
        mana = Integer.valueOf(stateParts[1]);
        manaSpent = Integer.valueOf(stateParts[2]);
    }

}
