package fi.tuomax.adventofcode.year2015.day22.spells;

import fi.tuomax.adventofcode.year2015.day22.GameObject;
import fi.tuomax.adventofcode.year2015.day22.players.Boss;
import fi.tuomax.adventofcode.year2015.day22.players.Hero;

public abstract class Spell 
extends GameObject
{

    private Integer price;

    public Integer getPrice() 
    {
        return price;
    }

    protected void setPrice(Integer price)
    {
        this.price = price;
    }

    private Integer effectCounter = 0;

    private Integer effectLength = 0;
    
    protected void setEffectLength(Integer effectLength) {
        this.effectLength = effectLength;
    }

    public Boolean isCastable()
    {
//        return effectCounter == -1;
        return effectCounter > -1;
}

    public void cast(Hero player, Boss opponent)
    {
        this.effectCounter = effectLength;
    }

    public void turn(Hero player, Boss opponent)
    {
        if (effectCounter > 0) {
            effect(player, opponent);
            effectCounter--;
        }
/*        if (effectCounter > -1) {
            effectCounter--;
        }*/
    }

    public Boolean isEffecting()
    {
        return effectCounter > 0;
    }

    public abstract void effect(Hero player, Boss opponent);

    @Override
    public String saveState() {
        return effectCounter.toString();
    }

    @Override
    public void restoreState(String state) {
        effectCounter = Integer.valueOf(state);
    }
    
}
