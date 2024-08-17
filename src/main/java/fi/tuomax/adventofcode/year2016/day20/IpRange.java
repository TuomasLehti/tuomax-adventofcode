package fi.tuomax.adventofcode.year2016.day20;

import fi.tuomax.adventofcode.commons.Range;

/**
 * A range of ips from Advent of Code 2016, day 20.
 */
public record IpRange(
    Range range,
    Boolean allowed
) { }