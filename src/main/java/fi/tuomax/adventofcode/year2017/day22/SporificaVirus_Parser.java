package fi.tuomax.adventofcode.year2017.day22;

import java.util.List;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.SparseGrid;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class SporificaVirus_Parser
extends Parser
{

    private SparseGrid<InfectionStatus> statusMap = new SparseGrid<>();

    public SparseGrid<InfectionStatus> getStatusMap() 
    {
        return statusMap;
    }

    private Integer mapSize = 0;

    public Integer getMapSize() 
    {
        return mapSize;
    }

    public SporificaVirus_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        mapSize = input.size();
        Long row = 0L;
        Long col = 0L;
        for (String line : input) {
            for (Character c : line.toCharArray()) {
                if (c.equals('#'))
                    statusMap.add(new Coordinates(col, row), InfectionStatus.INFECTED);
                else
                    statusMap.add(new Coordinates(col, row), InfectionStatus.CLEAN);
                col++;
            }
            row--;
            col = 0L;
        }
    }

}
