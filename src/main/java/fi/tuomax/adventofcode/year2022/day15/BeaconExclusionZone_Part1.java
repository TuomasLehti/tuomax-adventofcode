package fi.tuomax.adventofcode.year2022.day15;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Range;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 15, part 1:
 * Beacon Exclusion Zone.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/15">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class BeaconExclusionZone_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 15, 1,
            "Beacon Exclusion Zone", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new BeaconExclusionZone_Parser(input);
    }

    @Override
    protected void solve()
    {
        List<Sensor> sensors = ((BeaconExclusionZone_Parser) parser).getSensors();
        Long row = (long) getParamInt("y");
        List<Range> ranges = new ArrayList<>();
        for (Sensor sensor : sensors)
            if (sensor.noBeaconZoneReaches(row))
                ranges.add(sensor.noBeaconZone(row));
        ranges = join(ranges);
        Long answer = 0L;
        for (Range range : ranges) {
            answer += range.getLength();
            for (Coordinates beacon : Sensor.getBeacons())
                if (
                    beacon.y().equals(row) && 
                    range.contains(beacon.x())
                ) {
                    answer--;
                }
        }
        setAnswer(answer);
    }

    private List<Range> join(List<Range> ranges)
    {
        Collections.sort(ranges, new Comparator<Range>(){
            @Override
            public int compare(Range o1, Range o2) {
                if (o1.getStart().equals(o2.getStart())) {
                    return o1.getLength().compareTo(o2.getLength());
                } else {
                    return o1.getStart().compareTo(o2.getStart());
                }
            }
        });
        Deque<Range> que = new ArrayDeque<>(ranges);
        Range current = que.pop();
        List<Range> result = new ArrayList<>();
        while (!que.isEmpty()) {
            Range next = que.pop();
            if (current.joinable(next)) {
                current = (Range) current.join(next);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result;
    }

}
