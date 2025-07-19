package fi.tuomax.adventofcode.year2017.day25;

import fi.tuomax.adventofcode.commons.Direction.TurnDirection;

public record TuringInst (
    Boolean valueToWrite,
    TurnDirection dir,
    String nextState
){}
