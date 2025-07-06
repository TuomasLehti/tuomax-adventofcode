package fi.tuomax.adventofcode.year2017.day21;

import fi.tuomax.adventofcode.commons.Coordinates;

/**
 * Many of Advent of Code puzzles feature a grid of booleans.
 */
public class SparseBooleanGrid
extends SparseGrid<Boolean>
{

    public SparseBooleanGrid()
    {
        super();
    }

    /**
     * Creates a boolean grid from a string.
     * @param input
     *      The string.
     * @param separator
     *      The string which separates rows in the input string.
     * @param trueChar
     *      The string which denotes a true cell.
     */
    public SparseBooleanGrid(String input, String separator, Character trueChar)
    {
        long rowIdx = 0;
        long colIdx = 0;
        String[] rows = input.split(separator);
        for (String row : rows) {
            for (Character c : row.toCharArray()) {
                if (c.equals(trueChar))
                    add(new Coordinates(colIdx, rowIdx), true);
                else
                    add(new Coordinates(colIdx, rowIdx), null);
                colIdx++;
            }
            rowIdx--;
            colIdx = 0;
        }
    }

    public String asString(
        String trueStr, 
        String falseStr, 
        String colSeparator, 
        String rowSeparator
    ) {
        StringBuilder gridBuilder = new StringBuilder();
        StringBuilder rowBuilder = new StringBuilder();
        for (long rowIdx = topLeft.y(); bottomRight.y() <= rowIdx; rowIdx--) {
            rowBuilder.setLength(0);
            for (long colIdx = topLeft.x(); colIdx <= bottomRight.x(); colIdx++) {  
                if (rowBuilder.length() > 0)
                    rowBuilder.append(colSeparator);
                if (get(new Coordinates(colIdx, rowIdx)) != null && get(new Coordinates(colIdx, rowIdx)))
                    rowBuilder.append(trueStr);
                else
                    rowBuilder.append(falseStr);
            }
            if (gridBuilder.length() > 0)
                gridBuilder.append(rowSeparator);
            gridBuilder.append(rowBuilder.toString());
        }
        return gridBuilder.toString();
    }

    @Override
    public String toString()
    {
        return asString("#", ".", "", "/");
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || (!(o instanceof SparseBooleanGrid))) return false;
        if (o == this) return true;
        SparseBooleanGrid other = (SparseBooleanGrid) o;
        return asString("#", ".", "", "/").equals(
                other.asString("#", ".", "", "/")
        );
    }

    @Override
    public int hashCode()
    {
        return toString().hashCode();
    }

    @Override
    public SparseBooleanGrid copy()
    {
        return (SparseBooleanGrid) super.copy();
    }

    @Override
    protected SparseGrid<Boolean> createCopy()
    {
        return new SparseBooleanGrid();
    }
    
}
