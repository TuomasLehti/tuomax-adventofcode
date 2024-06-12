package fi.tuomax.adventofcode.commons.pathfinding;

/**
 * A edge of a graph used for path finding.
 */
public record Edge(
    Node neighbor,
    Integer weight
) { 

}
