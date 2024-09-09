package fi.tuomax.adventofcode.year2022.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Range;

public class Sensor 
{

    private Coordinates position;

    private Coordinates closestBeacon;

    public Sensor(String aocInput)
    {
        Pattern pattern = Pattern.compile("(-{0,1}\\d+)");
        Matcher matcher = pattern.matcher(aocInput);
        List<Long> matches = new ArrayList<>();
        while (matcher.find())
            matches.add(Long.valueOf(matcher.group()));
        position = new Coordinates(
            Long.valueOf(matches.get(0)),
            Long.valueOf(matches.get(1))
        );
        closestBeacon = new Coordinates(
            Long.valueOf(matches.get(2)),
            Long.valueOf(matches.get(3))
        );
    }

    public Long taxicabDistanceToBeacon()
    {
        return position.taxicabDistance(closestBeacon);
    }

    public Range noBeaconZone(Long row)
    throws IndexOutOfBoundsException
    {
        Long dist = taxicabDistanceToBeacon();
        dist -= Math.abs(position.y() - row);
        if (dist < 0)
            throw new IndexOutOfBoundsException();
        return new Range(position.x() - dist, position.x() + dist);
    }

    public Boolean noBeaconZoneReaches(Long row)
    {
        Long dist = taxicabDistanceToBeacon();
        dist -= Math.abs(position.y() - row);
        return dist >= 0;
    }
    
}
