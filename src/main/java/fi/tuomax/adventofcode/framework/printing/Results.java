package fi.tuomax.adventofcode.framework.printing;

import java.util.List;

public record Results(
    String mainHeading,
    String subHeading,
    List<ResultRow> rows
) 
{
}
