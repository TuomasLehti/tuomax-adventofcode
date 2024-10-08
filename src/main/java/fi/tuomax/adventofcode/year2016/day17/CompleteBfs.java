package fi.tuomax.adventofcode.year2016.day17;

import fi.tuomax.adventofcode.commons.Bfs;
import fi.tuomax.adventofcode.commons.BfsState;

/**
 * Searches for every possible state. State class must not return any next
 * states, if it is a target state.
 */
public class CompleteBfs 
extends Bfs
{

    /** 
     * No early exit. The search is being run until there are no more states
     * to explore in the queue. After the search is finished, the states can
     * be examined by getQueue().
     */
    @Override
    protected Boolean finished(BfsState state) 
    {
        return false;
    }
    
}
