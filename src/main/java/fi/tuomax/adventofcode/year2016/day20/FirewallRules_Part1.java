package fi.tuomax.adventofcode.year2016.day20;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class FirewallRules_Part1 
extends FirewallRules
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 20, 1,
            "Firwall Rules", ""
        );
    }

    @Override
    protected void solve() 
    {
        super.solve();
        for (IpRange ipRange : ipRanges)
            if (ipRange.allowed()) {
                setAnswer(ipRange.range().getStart());
                return;
            }
    }

    
}
