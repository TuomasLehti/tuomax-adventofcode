package fi.tuomax.adventofcode.year2016.day18;

/**
 * Represents a row of traps.
 */
public class Trap 
{

    private String input;

    public String getInput() 
    {
        return input;
    }

    private boolean[] traps;

    /**
     * Creates a row of traps from Advent of Code input.
     * @param input
     *      A row of text from which the row of traps is created. 
     *      ^ means there's a trap, . means it's a safe spot.
     */
    public Trap(String input)
    {
        this.input = input;
        traps = new boolean[input.length()];
        int i = 0;
        for (char c : input.toCharArray())
            traps[i++] = (c == '^');
    }

    /**
     * Returns the next row of traps. The rules for the "entrapment" of the 
     * next row can be found from the Advent of Code website.
     */
    public Trap getNext()
    {
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < traps.length; idx++)
            sb.append(isNewTileTrap(idx) ? '^' : '.');
        return new Trap(sb.toString());
    }

    /**
     * Counts the number of safe spots on this row.
     */
    public Integer countSafes()
    {
        Integer result = 0;
        for (boolean trap : traps)
            if (!trap) result++;
        return result;
    }

    /**
     * <p>Tells whether a spot in the next row will be safe or not.</p>
     * 
     * <p>The truth table for the rules reveal that the test for the safeness
     * of a spot boils down to a simple xor. The spot on the next row will 
     * not be safe if one of these is true:</p>
     * 
     * <table>
     * <tr> <th>left</th>   <th>center</th> <th>right</th>  </tr>
     * <tr> <td>trap</td>   <td>trap</td>   <td>safe</td>   </tr>
     * <tr> <td>safe</td>   <td>trap</td>   <td>trap</td>   </tr>
     * <tr> <td>trap</td>   <td>safe</td>   <td>safe</td>   </tr>
     * <tr> <td>safe</td>   <td>safe</td>   <td>trap</td>   </tr>
     * </table>
     * @param idx
     *      The spot in question.
     * @return
     *      Will the spot in question be unsafe?
     */
    private boolean isNewTileTrap(int idx) 
    {
        boolean leftIsTrap = isOldTileTrap(idx - 1);
        boolean rightIsTrap = isOldTileTrap(idx + 1);
        return leftIsTrap ^ rightIsTrap;
    }

    /**
     * Tells whether a spot in this row is safe or not.
     * @param idx
     *      The spot in question.
     * @return
     *      Is the spot in question unsafe?
     */
    private boolean isOldTileTrap(int idx)
    {
        if (idx < 0 || idx >= traps.length) 
            return false;
        else
            return traps[idx];
    }
    
}
