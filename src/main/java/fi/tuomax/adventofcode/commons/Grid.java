package fi.tuomax.adventofcode.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<T> 
implements Iterable<ArrayList<T>>
{

    private ArrayList<ArrayList<T>> rows;

    public Grid(Integer width, Integer height) 
    {
        rows = new ArrayList<>(height - 1);
        for (int r = 0; r < height; r++) {
            rows.add(new ArrayList<>(width - 1));
            for (int c = 0; c < width; c++) {
                rows.get(r).add(null);
            }
        }
    }

    public T get(Integer col, Integer row)
    throws IndexOutOfBoundsException
    {
        if (row >= 0 && row < rows.size() && col >= 0 && col < rows.get(0).size())
            return rows.get(row).get(col);
        else
            throw new IndexOutOfBoundsException(
                String.format(
                    "Tried to get (%d, %d), grid size only (%d, %d)",
                    col,
                    row,
                    rows.get(0).size(),
                    rows.size()
                )
            );
    }

    public T get(Coordinates c)
    throws IndexOutOfBoundsException
    {
        return get(c.xAsInt(), c.yAsInt());
    }

    public void set(Integer col, Integer row, T contents)
    throws IndexOutOfBoundsException
    {
        rows.get(row).set(col, contents);
    }

    public void set(Coordinates c, T contents)
    {
        set(c.xAsInt(), c.yAsInt(), contents);
    }

    public Integer width()
    {
        return rows.get(0).size();
    }

    public Integer height()
    {
        return rows.size();
    }

    public Boolean exists(Integer col, Integer row)
    {
        try {
            get(col, row);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public Boolean exists(Coordinates c)
    {
        return exists(c.xAsInt(), c.yAsInt());
    }

    public Grid<T> subgrid(Integer fromCol, Integer fromRow, Integer toCol, Integer toRow)
    {
        int numOfCols = toCol - fromCol + 1;
        int numOfRows = toRow - fromRow + 1;
        Grid<T> result = new Grid<>(numOfCols, numOfRows);
        for (int row = 0; row < numOfRows; row++)
            for (int col = 0; col < numOfCols; col++)
                result.set(col, row, this.get(fromCol + col, fromRow + row));
        return result;
    }

    public Grid<T> subgrid(Coordinates from, Coordinates to)
    {
        return subgrid(from.xAsInt(), from.yAsInt(), to.xAsInt(), to.yAsInt());
    }

    public List<T> neighbors(Integer col, Integer row)
    {
        List<T> result = new ArrayList<>();
        if (exists(col - 1, row - 1)) result.add(get(col - 1, row - 1));
        if (exists(col, row - 1)) result.add(get(col, row - 1));
        if (exists(col + 1, row - 1)) result.add(get(col + 1, row - 1));
        if (exists(col - 1, row )) result.add(get(col - 1, row));
        if (exists(col + 1, row)) result.add(get(col + 1, row));
        if (exists(col - 1, row + 1)) result.add(get(col - 1, row + 1));
        if (exists(col, row + 1)) result.add(get(col, row + 1));
        if (exists(col + 1, row + 1)) result.add(get(col + 1, row + 1));
        return result;
    }

    public List<T> neighbors(Coordinates c)
    {
        return neighbors(c.xAsInt(), c.yAsInt());
    }

    @Override
    public Iterator<ArrayList<T>> iterator() 
    {
        return rows.iterator();
    }
    
}
