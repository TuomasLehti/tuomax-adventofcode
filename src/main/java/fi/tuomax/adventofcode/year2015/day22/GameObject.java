package fi.tuomax.adventofcode.year2015.day22;

/**
 * A base class for all the objects in the game.
 */
public abstract class GameObject 
{

    public abstract String saveState();

    public abstract void restoreState(String state);
    
}
