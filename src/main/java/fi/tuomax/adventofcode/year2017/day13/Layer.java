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

    private Integer cycle;

    public Layer(String input)
    {
        this.depth = Integer.valueOf(input.split(": ")[0]);
        this.range = Integer.valueOf(input.split(": ")[1]);

        this.cycle = (this.range - 1) * 2;
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

    public Boolean blocksAt(Integer picosecond)
    {
        return (picosecond % cycle) == 0;
    }

    public void reset()
    {
        scanner = 0;
        scanDir = 1;
    }

    public static void visualize(Map<Integer, Layer> layers)
    {
        Integer maxRange = Integer.MIN_VALUE;
        Integer maxDepth = Integer.MIN_VALUE;
        for (Integer idx : layers.keySet()) {
            maxRange = Math.max(maxRange, layers.get(idx).getRange());
            maxDepth = Math.max(maxDepth, idx);
        }
        for (int col = 0; col <= maxDepth; col++) {
            System.out.print(col);
            if (col < 10) System.out.print(" ");
            System.out.print("   ");
        }
        System.out.println();
        for (int row = 0; row <= maxRange; row++) {
            for (int col = 0; col <= maxDepth; col++) {
                if (layers.getOrDefault(col, null) == null) {
                    if (row == 0) {
                        System.out.print("... ");
                    } else {
                        System.out.print("    ");
                    }
                } else {
                    if (row < layers.get(col).range) {
                        if (layers.get(col).scanner.equals(row)) {
                            System.out.print("[S] ");
                        } else {
                            System.out.print("[ ] ");
                        }
                    } else {
                        System.out.print("    ");
                    }
                }
            }
            System.out.println();
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

    public static void resetAll(Map<Integer, Layer> layers)
    {
        for (Integer idx : layers.keySet()) {
            layers.get(idx).reset();
        }
    }
    
}


/*

..
x.
.x
x.

2 = every 2

...
x..
.x.
..x
.x.
x..

3 = every 4

....
x...
.x..
..x.
...x
..x.
.x..
x...

4 = every 6

.....
x....
.x...
..x..
...x.
....x
...x.
..x..
.x...
x....

5 = every 8

......
x.....
.x....
..x...
...x..
....x.
.....x
....x.
...x..
..x...
.x....
x.....

6 = every 10

 */