package fi.tuomax.adventofcode.year2016.day07;

import java.util.ArrayList;
import java.util.List;

public class IpSslSupportChecker 
extends IpSupportChecker
{

    @Override
    protected Boolean check() 
    {
        List<String> abas = new ArrayList<>();
        for (int i = 0; i < parts.length; i += 2)
            abas.addAll(fetchAbas(parts[i]));
        if (abas.size() == 0)
            return false;
        for (String aba : abas)
            for (int i = 1; i < parts.length; i += 2)
                if (hasBab(parts[i], aba))
                    return true;
        return false;
    }

    private boolean hasBab(String part, String aba) 
    {
        String bab = aba.substring(1) + aba.substring(1, 2);
        return (part.contains(bab));
    }

    private List<String> fetchAbas(String s)
    {
        List<String> abas = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++)
            if (isAba(s.substring(i, i + 3)))
                abas.add(s.substring(i, i + 3));
        return abas;
    }

    private Boolean isAba(String s)
    {
        return 
            s.length() == 3 &&
            s.charAt(0) == s.charAt(2) &&
            s.charAt(0) != s.charAt(1);

    }
    
}
