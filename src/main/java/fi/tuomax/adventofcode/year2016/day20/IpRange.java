package fi.tuomax.adventofcode.year2016.day20;

import fi.tuomax.adventofcode.commons.Range;

public record IpRange(
    Range range,
    Boolean allowed
) { }