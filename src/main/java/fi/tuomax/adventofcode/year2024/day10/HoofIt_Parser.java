package fi.tuomax.adventofcode.year2024.day10;

import java.util.List;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class HoofIt_Parser
extends Parser
{

    public HoofIt_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        cells = new Grid<MapCell>(input.get(0).length(), input.size());

        int row = 0;
        int col = 0;
        for (String line : input) {
            for (Character c : line.toCharArray()) {
                cells.set(
                    col, row, 
                    new MapCell(
                        Coordinates.fromInteger(col, row), 
                        Integer.valueOf(c.toString())
                    )
                );
                col++;
            }
            row++;
            col = 0;
        }
        for (int r = 0; r < cells.height(); r++)
            for (int c = 0; c < cells.width(); c++)  {
                Coordinates cell = Coordinates.fromInteger(c, r);
                if (isReachableNeighbor(cell, new Coordinates(cell.x() - 1, cell.y())))
                    cells.get(cell).addReachableNeighbor(cells.get(new Coordinates(cell.x() - 1, cell.y())));
                if (isReachableNeighbor(cell, new Coordinates(cell.x() + 1, cell.y())))
                    cells.get(cell).addReachableNeighbor(cells.get(new Coordinates(cell.x() + 1, cell.y())));
                if (isReachableNeighbor(cell, new Coordinates(cell.x(), cell.y() - 1)))
                    cells.get(cell).addReachableNeighbor(cells.get(new Coordinates(cell.x(), cell.y() - 1)));
                if (isReachableNeighbor(cell, new Coordinates(cell.x(), cell.y() + 1)))
                    cells.get(cell).addReachableNeighbor(cells.get(new Coordinates(cell.x(), cell.y() + 1)));
            }
    }

    private Boolean isReachableNeighbor(Coordinates cell, Coordinates neighbor)
    {
        if (!cells.exists(neighbor)) return false;
        MapCell neighboringCell = cells.get(neighbor);
        Integer neighborElevation = neighboringCell.getElevation();
        return cells.get(cell).getElevation().equals(neighborElevation -1);
    }

    private Grid<MapCell> cells;

    public Grid<MapCell> getCells() {
        return cells;
    }

}
