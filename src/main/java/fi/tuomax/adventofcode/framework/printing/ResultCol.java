package fi.tuomax.adventofcode.framework.printing;

import fi.tuomax.adventofcode.framework.solving.Solver;

public record ResultCol(
    String answer,
    Long time,
    Solver solver
) 
{
}
