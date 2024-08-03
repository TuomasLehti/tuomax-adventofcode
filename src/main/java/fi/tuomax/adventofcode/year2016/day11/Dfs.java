package fi.tuomax.adventofcode.year2016.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Depth first search.
 */
public class Dfs 
{

    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    /** 
     * Stores all the visited states.
     */
    private List<DfsState> queue = new ArrayList<>();

    private Integer idx = 0;

    public DfsState search(DfsState start)
    {
        int gen = -1;
        queue.add(start);
        while (idx < queue.size()) {
            if (queue.get(idx).getStep() != gen) {
                gen = queue.get(idx).getStep();
                LOGGER.debug(String.format("Step %d, %d states.", gen, queue.size() - idx));
            }
            Set<DfsState> nextStates = queue.get(idx).nextStates();
            for (DfsState state : nextStates) {
//                LOGGER.debug(state.toString());
                if (state.isTargetState())
                    return state;
                else if (!queue.contains(state))
                    queue.add(state);
            }
            idx++;
        }
        return null;
    }
    
}
