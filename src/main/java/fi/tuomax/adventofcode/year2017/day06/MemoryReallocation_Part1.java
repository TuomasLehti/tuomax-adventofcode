package fi.tuomax.adventofcode.year2017.day06;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Solves Advent of Code 2017, day 6, part 1:
 * Memory Reallocation.</p>
 * 
 * <p>TODO: make it faster</p>
 * <p>TODO: IntegerListParserize</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/6">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class MemoryReallocation_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 6, 1,
            "Memory Reallocation", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new MemoryReallocation_Parser(input);
    }

    private String banksToString(List<Integer> banks) 
    {
        List<String> parts = new ArrayList<>();
        for (Integer bank : banks) {
            parts.add(bank.toString());
        }
        return String.join(" ", parts);
    }

    private int getMaxBankIdx(List<Integer> banks)
    {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int idx = 0; idx < banks.size(); idx++) {
            if (banks.get(idx) > max) {
                max = banks.get(idx);
                maxIdx = idx;
            }
        }
        return maxIdx;
    }

    private void reallocate(List<Integer> banks)
    {
        int idx = getMaxBankIdx(banks);
        int blocks = banks.get(idx);
        banks.set(idx, 0);
        int reidx = (idx + 1) % banks.size();
        while (blocks > 0) {
            banks.set(reidx, banks.get(reidx) + 1);
            reidx = (reidx + 1) % banks.size();
            blocks--;
        }
    }

    protected List<String> memo = new ArrayList<>();

    protected String currentStateOfBanks = "";

    protected Integer cycle = 0;

    @Override
    protected void solve()
    {
        List<Integer> banks = ((MemoryReallocation_Parser) parser).getInts();
        currentStateOfBanks = banksToString(banks);
        while (!memo.contains(currentStateOfBanks)) {
            memo.add(currentStateOfBanks);
            reallocate(banks);
            currentStateOfBanks = banksToString(banks);
            cycle++;
        }
        setAnswer(cycle);
    }

}
