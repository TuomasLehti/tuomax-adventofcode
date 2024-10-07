package fi.tuomax.adventofcode.year2022.day20;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 20, part 1:
 * Grove Positioning System.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/20">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class GrovePositioningSystem_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 20, 1,
            "Grove Positioning System", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new GrovePositioningSystem_Parser(input);
    }

    private void toFile(String filename, GpsMixer nums, GpsSequence seq)
    {
        List<GpsNumber> printees = new ArrayList<>(seq.nums);
        Collections.sort(printees, new Comparator<GpsNumber>(){
            @Override
            public int compare(GpsNumber o1, GpsNumber o2) {
                return o1.currIdx - o2.currIdx;
            }
        });
        List<String> l = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            l.add(String.format(
                "%4d | old %6d | new %6d | %b", 
                i, 
                seq.getIdx(i).num, 
                nums.getMixed(i).num,
                seq.getIdx(i).num == nums.getMixed(i).num
            ));
        }
        try {
            Files.write(new File(filename).toPath(), l);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void solve()
    {
        

        GpsMixer nums = ((GrovePositioningSystem_Parser) parser).getNums();
        GpsSequence seq = ((GrovePositioningSystem_Parser) parser).getSeq();
//        toFile("00.txt", nums, seq);
//        System.out.println(nums.toString().equals(seq.toString()));

        for (int origIdx = 0; origIdx < nums.size(); origIdx++) {
            nums.moveByNum(origIdx);
//            seq.move(seq.nums.get(origIdx));
//            toFile(origIdx + ".txt", nums,seq);
//            System.out.println(nums.toString().equals(seq.toString()));
//            System.out.print("");
        }

        int zero = nums.getMixedZeroIdx();
        setAnswer(
            nums.getMixed(zero + 1000).num +
            nums.getMixed(zero + 2000).num +
            nums.getMixed(zero + 3000).num
        );
    }

}
