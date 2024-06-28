package fi.tuomax.adventofcode.year2016.day07;

import fi.tuomax.adventofcode.framework.solving.Metadata;

public class InternetProtocolVersion7_Part1 
extends InternetProtocolVersion7_Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 7, 1,
            "Internet Protocol Version 7", ""
        );
    }

    @Override
    protected IpSupportChecker manufactureChecker() 
    {
        return new IpTlsSupportChecker();
    }
    
}
