package fi.tuomax.adventofcode.year2024.day09;

import java.util.ArrayList;
import java.util.List;

public class DiskMap 
{

    private List<HistoriansFile> files = new ArrayList<>();
    
    public void addHistoriansFile(HistoriansFile file) 
    {
        files.add(file);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files.size(); i++) {
            sb.append(String.format("%d", files.get(i).getIndex() % 10).repeat(files.get(i).getLength()));
             if (i < files.size() - 1) {
                Long freeSize = files.get(i + 1).getStart() - files.get(i).getEnd();
                Integer free = Integer.valueOf(freeSize.toString());
                sb.append(".".repeat(free));
            } 
        }
        return sb.toString();
    }
    
}
