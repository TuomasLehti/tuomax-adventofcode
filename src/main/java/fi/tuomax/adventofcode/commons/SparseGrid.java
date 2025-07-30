package fi.tuomax.adventofcode.commons;

import java.util.HashMap;
import java.util.Map;

import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

/**
 * A grid which contains only the remarkable cells.
 * 
 * When creating subclasses of this class, one must override the copy()- and
 * createCopy()-methods, if he or she wishes to use the shallow copying 
 * feature.
 * 
 * If a grid of certain size is wanted, the user of this class should add
 * null cells to the positions in which there is nothingness.
 */
public class SparseGrid<T> 
{

    protected Map<Coordinates, T> cells = new HashMap<>();

    protected Coordinates topLeft = Coordinates.ORIGIN;

    public Coordinates getTopLeft() 
    {
        return topLeft;
    }

    protected Coordinates bottomRight = Coordinates.ORIGIN;

    public Coordinates getBottomRight() 
    {
        return bottomRight;
    }

    public void add(Coordinates coords, T cell)
    {
        cells.put(coords, cell);
        /* The y coordinates get larger when going up, thus the upper left 
         * corner's y coordinate is the largest we've seen so far. */
        topLeft = new Coordinates(
            Math.min(coords.x(), topLeft.x()),
            Math.max(coords.y(), topLeft.y())
        );
        bottomRight = new Coordinates(
            Math.max(coords.x(), bottomRight.x()),
            Math.min(coords.y(), bottomRight.y())
        );
    }

    public void addAll(SparseGrid<T> cells)
    {
        for (Coordinates pos : cells.cells.keySet())
            add(pos, cells.cells.get(pos));
    }

    public T get(Coordinates coords)
    {
        return cells.getOrDefault(coords, null);
    }

    public Boolean exists(Coordinates coords)
    {
        return cells.keySet().contains(coords);
    }

    /**
     * Returns the width of this grid.
     * @return
     *      The width of the grid.
     */
    public Long width()
    {
        return bottomRight.x() - topLeft.x() + 1;
    }

    /**
     * Returns the height of this grid.
     * @return
     *      The height of the grid.
     */
    public Long height()
    {
        return topLeft.y() - bottomRight.y() + 1;
    }

    /**
     * Returns a shallow copy of this grid.
     * @return
     *      A shallow copy of this grid.
     */
    public SparseGrid<T> copy()
    {
        SparseGrid<T> copy = createCopy();
        for (Coordinates position : cells.keySet())
            copy.add(position, get(position));
        return copy;
    }

    /**
     * A factory method to create an instance of a sublass.
     */
    protected SparseGrid<T> createCopy()
    {
        return new SparseGrid<>();
    }

    /**
     * Translates the cells by a certain amount.
     * @param amount
     *      The amount to translate by.
     */
    public void translate(Coordinates amount)
    {
        Map<Coordinates, T> newCells = new HashMap<>();
        for (Coordinates position : cells.keySet())
            newCells.put(position.translate(amount), get(position));
        cells = newCells;
        topLeft = topLeft.translate(amount);
        bottomRight = bottomRight.translate(amount);
    }

    /**
     * Returns a shallow copy of this grid, which is translated by a certain 
     * amount.
     * @param amount
     *      The amount to translate by.
     * @return
     *      A copy of the translated grid.
     */
    public SparseGrid<T> getTranslatedCopy(Coordinates amount)
    {
        SparseGrid<T> copied = copy();
        copied.translate(amount);
        return copied;
    }

    /**
     * Rotates the cells around the origin, and translates them so that the
     * upper left corner of the grid is at the same position as in the original
     * grid.
     * @param direction
     *      The direction to rotate. Use {@code RIGHT} to rotate clockwise and 
     *      {@code LEFT} to rotate counterclockwise.
     */
    public void rotate(TurnDirection direction)
    {
        Map<Coordinates, T> newCells = new HashMap<>();
        Coordinates newTopLeft = new Coordinates(Long.MAX_VALUE, Long.MIN_VALUE);
        Coordinates newBottomRight = new Coordinates(Long.MIN_VALUE, Long.MAX_VALUE);
        for (Coordinates position : cells.keySet()) {
            Coordinates newPosition = position.rotate90Degrees(direction);
            newCells.put(newPosition, get(position));
            newTopLeft = new Coordinates(
                Math.min(newPosition.x(), newTopLeft.x()),
                Math.max(newPosition.y(), newTopLeft.y())
            );
            newBottomRight = new Coordinates(
                Math.max(newPosition.x(), newBottomRight.x()),
                Math.min(newPosition.y(), newBottomRight.y())
            );
        }
        cells = newCells;

        Coordinates translateAmount = new Coordinates(
            topLeft.x() - newTopLeft.x(),
            newTopLeft.y() - topLeft.y()
        );
        topLeft = newTopLeft;
        bottomRight = newBottomRight;
        translate(translateAmount);
    }

    public SparseGrid<T> getRotatedCopy(TurnDirection turn)
    {
        SparseGrid<T> copied = copy();
        copied.rotate(turn);
        return copied;
    }

    /**
     * Reflects the cells across the y-axis.
     */
    public void reflectHorizontally()
    {
        Map<Coordinates, T> newCells = new HashMap<>();
        Coordinates newTopLeft = new Coordinates(Long.MAX_VALUE, Long.MIN_VALUE);
        Coordinates newBottomRight = new Coordinates(Long.MIN_VALUE, Long.MAX_VALUE);
        for (Coordinates position : cells.keySet()) {
            Coordinates newPosition = new Coordinates(
                -position.x(),
                position.y()
            );
            newCells.put(newPosition, get(position));
            newTopLeft = new Coordinates(
                Math.min(newPosition.x(), newTopLeft.x()),
                Math.max(newPosition.y(), newTopLeft.y())
            );
            newBottomRight = new Coordinates(
                Math.max(newPosition.x(), newBottomRight.x()),
                Math.min(newPosition.y(), newBottomRight.y())
            );
        }
        cells = newCells;

        Coordinates translateAmount = new Coordinates(
            topLeft.x() - newTopLeft.x(),
            newTopLeft.y() - topLeft.y()
        );

        topLeft = newTopLeft;
        bottomRight = newBottomRight;
        translate(translateAmount);
    }

    /**
     * Reflects the cells across the x-axis.
     */
    public void reflectVertically()
    {
        Map<Coordinates, T> newCells = new HashMap<>();
        Coordinates newTopLeft = new Coordinates(Long.MAX_VALUE, Long.MIN_VALUE);
        Coordinates newBottomRight = new Coordinates(Long.MIN_VALUE, Long.MAX_VALUE);
        for (Coordinates position : cells.keySet()) {
            Coordinates newPosition = new Coordinates(
                position.x(),
                -position.y()
            );
            newCells.put(newPosition, get(position));
            newTopLeft = new Coordinates(
                Math.min(newPosition.x(), newTopLeft.x()),
                Math.max(newPosition.y(), newTopLeft.y())
            );
            newBottomRight = new Coordinates(
                Math.max(newPosition.x(), newBottomRight.x()),
                Math.min(newPosition.y(), newBottomRight.y())
            );
        }
        cells = newCells;

        Coordinates translateAmount = new Coordinates(
            topLeft.x() - newTopLeft.x(),
            newTopLeft.y() - topLeft.y()
        );

        topLeft = newTopLeft;
        bottomRight = newBottomRight;
        translate(translateAmount);
    }

    public SparseGrid<T> getHorizontallyReflectedCopy()
    {
        SparseGrid<T> copied = copy();
        copied.reflectHorizontally();
        return copied;
    }

    /**
     * Translates the cells so that the upper-left corner is at the origin.
     */
    public void normalize()
    {
        Coordinates translationAmount = new Coordinates(
            -topLeft.x(), -topLeft.y()
        );
        translate(translationAmount);
    }

    /**
     * Returns a shallow copy of a part of this grid.
     * @param topLeft
     *      Top left corner of the subgrid, inclusive.
     * @param bottomRight
     *      Bottom right corner of the subgrid, exclusive.
     * @return
     *      A copy of a part of this grid.
     */
    public SparseGrid<T> subgrid(Coordinates topLeft, Coordinates bottomRight)
    {
        SparseGrid<T> copy = createCopy();
        Coordinates translationAmount = new Coordinates(-topLeft.x(), -topLeft.y());
        for (long row = topLeft.y(); bottomRight.y() < row; row--)
            for (long col = topLeft.x(); col < bottomRight.x(); col++) {
                Coordinates pos = new Coordinates(col, row);
                if (exists(pos))
                    copy.add(pos.translate(translationAmount), get(pos));
            }
        return copy;

    }
    
}
