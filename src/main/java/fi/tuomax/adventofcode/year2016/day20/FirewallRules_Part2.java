package fi.tuomax.adventofcode.year2016.day20;

import fi.tuomax.adventofcode.framework.solving.Metadata;

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
