package fi.tuomax.adventofcode.year2017.day13;

import java.util.Map;

public class Layer {

    private Integer depth = -1;

    public Integer getDepth() 
    {
        return depth;
    }

    private Integer range = -1;

    public Integer getRange() 
    {
        return range;
    }

    private Integer scanner = 0;

    public Integer getScanner() 
    {
        return scanner;
    }

    private Integer scanDir = 1;

    public Layer(String input)
    {
        this.depth = Integer.valueOf(input.split(": ")[0]);
        this.range = Integer.valueOf(input.split(": ")[1]);
    }

    public void step()
    {
        scanner += scanDir;
        if (scanner.equals(0)) {
            scanDir = 1;
        } else if (scanner.equals(getRange() - 1)) {
            scanDir = -1;
        }
    }

    public static void visualize(Map<Integer, Layer> layers)
    {
        Integer maxDepth = Integer.MIN_VALUE;
        Integer maxIdx = Integer.MIN_VALUE;
        for (Integer idx : layers.keySet()) {
            maxDepth = Math.max(maxDepth, layers.get(idx).getRange());
            maxIdx = Math.max(maxIdx, idx);
        }
        for (int col = 0; col <= maxIdx; col++) {
            System.out.print(col);
            if (col < 10) System.out.print(" ");
            System.out.print("   ");
        }
        System.out.println();
        for (int row = 0; row <= maxDepth; row++) {
        }
    }

    public static Integer getMaxDepth(Map<Integer, Layer> layers)
    {
        Integer maxDepth = Integer.MIN_VALUE;
        for (Integer idx : layers.keySet()) {
            maxDepth = Math.max(maxDepth, idx);
        }
        return maxDepth;
    }

    public static void stepAll(Map<Integer, Layer> layers)
    {
        for (Integer idx : layers.keySet()) {
            layers.get(idx).step();
        }
    }
    
}
