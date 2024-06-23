package fi.tuomax.adventofcode.year2015.day24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.tuomax.adventofcode.framework.parsing.IntegerListParser;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class ItHangsInTheBalance_Part1 
extends Solver
{

    private List<Group> groups = new ArrayList<>();

    Integer level = -1;

    Integer minPackageFound = Integer.MAX_VALUE;

    private Logger logger = LoggerFactory.getLogger("");

    private void divide(Group source, Group target, Long targetWeight)
    {
        level++;
        if (source.empty() || target.numOfPackages() > minPackageFound) {
            level--;
            return;
        } 
//        System.out.println(String.format("%-4d | %s -> %d | %s -> %d", level, source, source.weight(), target, target.weight()));

        target.push(source.pop());
        if (target.weight().equals(targetWeight)) {
//            logger.info("Found " + target.copy());
//            System.out.println("Found " + target.copy());
            groups.add(target.copy());
            minPackageFound = Math.min(minPackageFound, target.numOfPackages());
        } else if (target.weight() < targetWeight) {
            divide(source.copy(), target.copy(), targetWeight);
        }
        target.pop();
        divide(source.copy(), target.copy(), targetWeight);

        level--;
    }

    @Override
    protected void solve() 
    {
        Group everyPackage = new Group(((IntegerListParser) parser).getIntegers());
        Long target = everyPackage.weight() / 3;

        while (!everyPackage.empty()) {
            Group front = new Group();
            divide(everyPackage, front, target);
            everyPackage.pop();
        }

        groups.sort(new Comparator<Group>() {
            @Override
            public int compare(Group o1, Group o2) {
                if (o1.numOfPackages().equals(o2.numOfPackages()))
                    return o1.quantumEntanglement().compareTo(o2.quantumEntanglement());
                else
                    return o1.numOfPackages().compareTo(o2.numOfPackages());
            }
        });

//        for (Group group : groups) System.out.println(group);

        setAnswer(groups.get(0).quantumEntanglement().toString());
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(        
            2015, 
            24, 
            1, 
            "It Hangs in the Balance", 
            ""
        );    
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new IntegerListParser(input);
    }
    
}
