package fi.tuomax.adventofcode.year2016.day07;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import fi.tuomax.adventofcode.PuzzleTester;
import fi.tuomax.adventofcode.framework.solving.Metadata;

public class Test_Ip 
extends PuzzleTester
{

    @Test
    public void testTlsSupported()
    {
        IpSupportChecker checker = new IpTlsSupportChecker();
        readJson(new Metadata(2016, 7, null, null, null), "tests.json");
        List<String> supported = getStrings(json.getJSONArray("tls_supported"));
        for (String s : supported)
            assertTrue(s, checker.checkSupport(s));
    }

    @Test
    public void testTlsUnSupported()
    {
        IpSupportChecker checker = new IpTlsSupportChecker();
        readJson(new Metadata(2016, 7, null, null, null), "tests.json");
        List<String> unsupported = getStrings(json.getJSONArray("tls_unsupported"));
        for (String s : unsupported)
            assertFalse(s, checker.checkSupport(s));
    }

    @Test
    public void testSslSupported()
    {
        IpSupportChecker checker = new IpSslSupportChecker();
        readJson(new Metadata(2016, 7, null, null, null), "tests.json");
        List<String> supported = getStrings(json.getJSONArray("ssl_supported"));
        for (String s : supported)
            assertTrue(s, checker.checkSupport(s));
    }

    @Test
    public void testSslUnSupported()
    {
        IpSupportChecker checker = new IpSslSupportChecker();
        readJson(new Metadata(2016, 7, null, null, null), "tests.json");
        List<String> unsupported = getStrings(json.getJSONArray("ssl_unsupported"));
        for (String s : unsupported)
            assertFalse(s, checker.checkSupport(s));
    }
    
}
