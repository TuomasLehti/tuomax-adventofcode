package fi.tuomax.adventofcode.year2024.day09;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class DiskFragmenter_Parser
extends Parser
{

    private DiskMap diskMap = new DiskMap();

    public DiskMap getDiskMap() 
    {
        return diskMap;
    }

    public DiskFragmenter_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        long start = 0;
        for (int idx = 0; idx < input.get(0).length(); idx += 2) {
            int fileIdx = idx / 2;
            int size = Integer.valueOf(input.get(0).substring(idx, idx + 1));
            diskMap.addHistoriansFile(new HistoriansFile(fileIdx, start, size));
            start += size;
            if (idx < input.get(0).length() - 1)
                start += Integer.valueOf(input.get(0).substring(idx + 1, idx + 2));
        }
    }

}
