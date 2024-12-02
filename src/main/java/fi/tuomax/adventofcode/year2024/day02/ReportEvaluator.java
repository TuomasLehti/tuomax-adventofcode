package fi.tuomax.adventofcode.year2024.day02;

import java.util.List;

public class ReportEvaluator {

    public static Boolean isSafe(List<Integer> report)
    {
        return (isIncreasing(report) || isDecreasing(report)) && maxDifferenceOfWto(report);
    }
                
    private static boolean maxDifferenceOfWto(List<Integer> report) {
        for (int idx = 0; idx < report.size() - 1; idx++) {
            if (Math.abs(report.get(idx) - report.get(idx + 1)) > 3) return false;
        }
        return true;

    }
        
    private static boolean isDecreasing(List<Integer> report) {
        for (int idx = 0; idx < report.size() - 1; idx++) {
            if (report.get(idx) <= report.get(idx + 1)) return false;
        }
        return true;
    }

    private static boolean isIncreasing(List<Integer> report) {
        for (int idx = 0; idx < report.size() - 1; idx++) {
            if (report.get(idx) >= report.get(idx + 1)) return false;
        }
        return true;
    }
    
}
