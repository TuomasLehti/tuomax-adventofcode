package fi.tuomax.adventofcode.year2015.day22.players;

public class Boss 
extends Player
{

    private Integer damage;

    public Integer getDamage() 
    {
        return damage;
    }

    public Boss(Integer hitPoints, Integer damage) 
    {
        super(hitPoints);
        this.damage = damage;
    }

    @Override
    public String saveState() 
    {
        return getHitPoints().toString();
    }

    @Override
    public void restoreState(String state) 
    {
        setHitPoints(Integer.valueOf(state));
    }

    
}
