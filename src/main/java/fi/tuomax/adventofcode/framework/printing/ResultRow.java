package fi.tuomax.adventofcode.framework.printing;

import java.util.List;

public record ResultRow(
    String name,
    List<ResultCol> cols
) 
{

    public Boolean hasPart(Integer part)
    {
        for (ResultCol col : cols) 
            if (col.solver().getMetadata().part().equals(part))
                return true;
        return false;
    }

    public ResultCol getCol(Integer part)
    {
        for (ResultCol col : cols) 
            if (col.solver().getMetadata().part().equals(part))
                return col;
        throw new IndexOutOfBoundsException(
            String.format("Part %d not found.", part)
        );
    }

}
