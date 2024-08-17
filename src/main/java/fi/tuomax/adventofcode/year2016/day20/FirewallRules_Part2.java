package fi.tuomax.adventofcode.year2016.day20;

import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2016, day 20, part 2: 
 * Firewall Rules.</p>
 * 
 * <p>The solving starts from the parent class, which calculates the allowed
 * ips. This class then counts the amount of allowed ips.</p>
 *
 * @see 
 *      <a href="https://adventofcode.com/2016/day/20">
 *      Puzzle on the Advent of Code website.</a>
 */
public class FirewallRules_Part2
extends FirewallRules
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 20, 2,
            "Firwall Rules", ""
        );
    }

    @Override
    protected void solve() 
    {
        super.solve();
        Long sum = 0L;
        for (IpRange ipRange : ipRanges)
            if (ipRange.allowed()) 
                sum += ipRange.range().getLength();
        setAnswer(sum);
    }

    
}
