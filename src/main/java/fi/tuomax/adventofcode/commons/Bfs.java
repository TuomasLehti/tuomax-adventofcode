package fi.tuomax.adventofcode.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Breadth first search.
 */
public class Bfs 
{

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    /** 
     * Stores all the visited states.
     */
    private List<BfsState> queue = new ArrayList<>();

    public List<BfsState> getQueue() 
    {
        return queue;
    }

    private Integer idx = 0;

    public BfsState search(BfsState start)
    {
        int gen = -1;
        queue.add(start);
        while (idx < queue.size()) {
            if (queue.get(idx).getStep() != gen) {
                gen = queue.get(idx).getStep();
//                LOGGER.debug(String.format("Step %d, %d states.", gen, queue.size() - idx));
            }
            Set<BfsState> nextStates = queue.get(idx).nextStates();
            for (BfsState state : nextStates) {
                if (finished(state))
                    return state;
                else if (!queue.contains(state))
                    queue.add(state);
            }
            idx++;
        }
        return null;
    }

    protected Boolean finished(BfsState state) 
    {
        return state.isTargetState();
    }
    
}
