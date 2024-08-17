package fi.tuomax.adventofcode.year2016.day20;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.Range;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>The common part of solving Advent of Code 2016, day 20: 
 * Firewall Rules.</p>
 *
 * @see 
 *      <a href="https://adventofcode.com/2016/day/20">
 *      Puzzle on the Advent of Code website.</a>
 */
public abstract class FirewallRules 
extends Solver
{

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new FirewallRules_Parser(input);
    }

    protected List<IpRange> ipRanges = new ArrayList<>();

    @Override
    protected void solve() 
    {
        
        ipRanges.add(new IpRange(new Range(0L, parameters.getJSONObject("part" + getMetadata().part()).getLong("max_ip")), true));

        for (Range range : (FirewallRules_Parser) parser) {
            List<IpRange> newIpRanges = new ArrayList<>();
            for (IpRange ipRange : ipRanges) {
                if (!ipRange.range().overlaps(range)) {
                    newIpRanges.add(ipRange);
                } else {
                    List<Range> newRanges = ipRange.range().split(range);
                    if (newRanges.get(0) != null)
                        newIpRanges.add(new IpRange(newRanges.get(0), ipRange.allowed()));
                    if (newRanges.get(1) != null)
                        newIpRanges.add(new IpRange(newRanges.get(1), false));
                        if (newRanges.get(2) != null)
                        newIpRanges.add(new IpRange(newRanges.get(2), ipRange.allowed()));
                }
            }
            ipRanges = newIpRanges;
        }

    }
    
}
