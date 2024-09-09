package fi.tuomax.adventofcode.year2022.day15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.commons.Range;

public class Test_BeaconExclusionZone
extends PuzzleTester
{

    @Test
    public void test_Sensor()
    {
        Sensor sensor = new Sensor("Sensor at x=5, y=7: closest beacon is at x=-5, y=-7");
        assertEquals(24L, (long) sensor.taxicabDistanceToBeacon());
    }

    @Test
    public void test_Sensor_NoBeaconZone()
    {
        /*  5    0    5
         * ..#########..
         * .#####S####B.    0
         * ..#########..   -1
         * ...#######...   -2
         * ....#####....   -3
         * .....###.....   -4
         * ......#......   -5
         * .............
         */
        Sensor sensor = new Sensor("Sensor at x=0, y=0: closest beacon is at x=5, y=0");
        assertEquals(new Range(-5L, 5L), sensor.noBeaconZone(0L));
        assertEquals(new Range(-4L, 4L), sensor.noBeaconZone(1L));
        assertEquals(new Range(-4L, 4L), sensor.noBeaconZone(-1L));
        assertEquals(new Range(0L, 0L), sensor.noBeaconZone(-5L));

        try {
            assertEquals(new Range(0L, 0L), sensor.noBeaconZone(-6L));
            fail("No exception when expected.");
        } catch (IndexOutOfBoundsException e) {
            assert(true);
        } catch (Exception e) {
            fail("Wrong exception");
        }
    }

    @Test
    public void test_Sensor_NoBeaconZoneReaches()
    {
        Sensor sensor = new Sensor("Sensor at x=0, y=0: closest beacon is at x=5, y=0");
        assertTrue(sensor.noBeaconZoneReaches(0L));
        assertTrue(sensor.noBeaconZoneReaches(1L));
        assertTrue(sensor.noBeaconZoneReaches(-1L));
        assertFalse(sensor.noBeaconZoneReaches(6L));
        assertFalse(sensor.noBeaconZoneReaches(-6L));
    }

    @Test
    public void test_Part1()
    {
        runTests(new BeaconExclusionZone_Part1());
    }

    @Test
    public void test_Part2()
    {
        runTests(new BeaconExclusionZone_Part2());
    }

}
