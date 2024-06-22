package fi.tuomax.adventofcode.year2015.day16;

public enum Compound 
{
    CHILDREN,
    CATS,
    SAMOYEDS,
    POMERANIANS,
    AKITAS,
    VIZSLAS,
    GOLDFISH,
    TREES,
    CARS,
    PERFUMES;

    public static Compound fromString(String s)
    {
        switch (s) {
            case "children" :       return CHILDREN;
            case "cats" :           return CATS;
            case "samoyeds" :       return SAMOYEDS;
            case "pomeranians" :    return POMERANIANS;
            case "akitas" :         return AKITAS;
            case "vizslas" :        return VIZSLAS;
            case "goldfish" :       return GOLDFISH;
            case "trees" :          return TREES;
            case "cars" :           return CARS;
            case "perfumes" :       return PERFUMES;
        }
        throw new IllegalArgumentException(
            String.format("Unknown compound: %s.", s)
        );
    }
}
