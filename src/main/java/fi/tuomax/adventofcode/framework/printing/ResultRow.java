package fi.tuomax.adventofcode.framework.printing;

import java.util.List;

public record ResultRow(
    String name,
    List<ResultCol> cols
) 
{
}
