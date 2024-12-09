package fi.tuomax.adventofcode.year2024.day09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiskMap 
{

    private List<HistoriansFile> files = new ArrayList<>();
    
    public void addHistoriansFile(HistoriansFile file) 
    {
        files.add(file);
    }

    public Integer gapSizeAfter(Integer idx)
    {
        if (idx.equals(files.size() - 1)) return 0;
        return (files.get(idx + 1).getStart() - files.get(idx).getEnd() - 1);
    }

    public Boolean isContiguous()
    {
        for (int i = 0; i < files.size(); i++) {
            if (!gapSizeAfter(i).equals(0)) {
                return false;
            }
        }
        return true;
    }

    public void move()
    {
        int gapIdx = Integer.MIN_VALUE;
        int gapSize = Integer.MIN_VALUE;
        for (int i = 0; i < files.size() - 1; i++) {
            if (gapSizeAfter(i) > 0) {
                gapIdx = files.get(i).getEnd() + 1;
                gapSize = gapSizeAfter(i);
                break;
            }
        }
        if (files.get(files.size() - 1).getLength() <= gapSize) {
            files.get(files.size() - 1).move(gapIdx);
        } else {
            HistoriansFile file = files.get(files.size() - 1);
            HistoriansFile copy = file.copy();
            file.adjustLength(file.getLength() - gapSize);
            copy.adjustLength(gapSize);
            copy.move(gapIdx);
            addHistoriansFile(copy);
        }
        Collections.sort(files);
        System.out.print("");
    }

    public void fragment()
    {
        while (!isContiguous()) 
            move();
    }

    public Boolean movePart2()
    {
        Integer gapIdx = 0;
        while (gapIdx < files.size() - 1) {
            for (int fileIdx = files.size() - 1; fileIdx >= gapIdx; fileIdx--) {
                if (gapSizeAfter(gapIdx) >= files.get(fileIdx).getLength()) {
                    files.get(fileIdx).move(files.get(gapIdx).getEnd() + 1);
                    Collections.sort(files);
                    return true;
                }
            }
            gapIdx++;
        }
        return false;
    }

    private Integer getLastNonMovedFileIdx()
    {
        for (int fileIdx = files.size() - 1; fileIdx > 0; fileIdx--) {
            if (!files.get(fileIdx).hasMoved())
                return fileIdx;
        }
        return -1;
    }

    public void defragment()
    {
        Integer fileIdx = getLastNonMovedFileIdx();
        while (fileIdx > -1) {
//            System.out.println(toString());
            files.get(fileIdx).setMoved();
            for (int gapIdx = 0; gapIdx < fileIdx; gapIdx++) {
                if (gapSizeAfter(gapIdx) >= files.get(fileIdx).getLength()) {
                    files.get(fileIdx).move(files.get(gapIdx).getEnd() + 1);
                    Collections.sort(files);
                    break;
                }
            }
            fileIdx = getLastNonMovedFileIdx();
        }

    }

    public Long checkSum()
    {
        Long result = 0L;
        for (HistoriansFile file : files)
            result += file.checkSum();
        return result;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < files.size(); i++) {
            sb.append(String.format("%d", files.get(i).getIndex() % 10).repeat(files.get(i).getLength()));
            sb.append(".".repeat(gapSizeAfter(i)));
        }
        return sb.toString();
    }
    
}
