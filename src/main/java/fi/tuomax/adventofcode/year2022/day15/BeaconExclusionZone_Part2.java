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
 * <p>Solves Advent of Code 2022, day 15, part 2:
 * Beacon Exclusion Zone.</p>
 * 
 * TODO: search ways to make it faster
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/15">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class BeaconExclusionZone_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 15, 2,
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
        Long col = row; // Search area is always a square
        for (long i = 0; i <= row && getAnswer().isEmpty(); i++) {
            List<Range> ranges = exclusionZone(sensors, i);
            List<Range> gaps = gaps(ranges);
            for (Range gap : gaps)
                if (gap.getStart() >= 0 && gap.getStart() < col) {
                    setAnswer(gap.getStart() * 4_000_000 + i);
                    break;
                }
        }
    }

    private List<Range> exclusionZone(List<Sensor> sensors, Long row) 
    {
        List<Range> ranges = new ArrayList<>();
        for (Sensor sensor : sensors)
            if (sensor.noBeaconZoneReaches(row))
                ranges.add(sensor.noBeaconZone(row));
        ranges = join(ranges);
        return ranges;
    }

    private List<Range> join(List<Range> ranges)
    {
        List<Range> result = new ArrayList<>();
        if (ranges.isEmpty()) return result;
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
        while (!que.isEmpty()) {
            Range next = que.pop();
            if (current.joinable(next)) {
                current = current.join(next);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result;
    }

    /**
     * @param ranges
     *      Must be joined first.
     * @return
     */
    private List<Range> gaps(List<Range> ranges)
    {
        List<Range> gaps = new ArrayList<Range>();
        for (int i = 0; i < ranges.size() - 1; i++)
            gaps.add(new Range(ranges.get(i).getEnd() + 1, ranges.get(i + 1).getStart() - 1));
        return gaps;
    }

    private String visualize(List<Range> ranges, Range display)
    {
        List<Range> visible = new ArrayList<>();
        for (Range range : ranges)
            if (range.overlaps(display))
                visible.add(range.split(display).get(1));
        visible.addAll(gaps(visible));
        Collections.sort(visible, new Comparator<Range>(){
            @Override
            public int compare(Range o1, Range o2) {
                if (o1.getStart().equals(o2.getStart())) {
                    return o1.getLength().compareTo(o2.getLength());
                } else {
                    return o1.getStart().compareTo(o2.getStart());
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visible.size(); i++) {
            String c = ranges.contains(visible.get(i)) ? "#" : ".";
            sb.append(c.repeat(Integer.valueOf(visible.get(i).getLength().toString())));
        }
        return sb.toString();
    }

}
