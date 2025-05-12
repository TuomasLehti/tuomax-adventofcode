package fi.tuomax.adventofcode.year2017.day08;

public enum Operator 
{

    GREATER_OR_EQUAL_THAN,
    GREATER_THAN,
    EQUAL,
    LESS_THAN,
    LESS_OR_EQUAL_THAN,
    UNEQUAL;

    public static Operator fromString(String operator)
    {
        if (operator.equals(">")) {
            return GREATER_THAN;
        } else if (operator.equals("<")) {
            return LESS_THAN;
        } else if (operator.equals(">=")) {
            return GREATER_OR_EQUAL_THAN;
        } else if (operator.equals("<=")) {
            return LESS_OR_EQUAL_THAN;
        } else if (operator.equals("==")) {
            return EQUAL;
        } else if (operator.equals("!=")) {
            return UNEQUAL;
        }
        throw new IllegalArgumentException("Unknown operator: " + operator);
    }
    
}
