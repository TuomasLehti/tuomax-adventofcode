package fi.tuomax.adventofcode.year2017.day08;

public class Register 
{

    private Integer value = 0;

    public Integer getValue() 
    {
        return value;
    }

    public void changeValue(Integer offset)
    {
        value += offset;
        highestValue = Math.max(highestValue, value);
    }

    private Integer highestValue = 0;

    public Integer getHighestValue() {
        return highestValue;
    }

    public Boolean compare(Operator operator, Integer value)
    {
        if (operator == Operator.GREATER_OR_EQUAL_THAN) 
            return this.value >= value;
        else if (operator == Operator.GREATER_THAN) 
            return this.value > value;
        else if (operator == Operator.EQUAL) 
            return this.value.equals(value);
        else if (operator == Operator.LESS_THAN) 
            return this.value < value;
        else if (operator == Operator.LESS_OR_EQUAL_THAN) 
            return this.value <= value;
        else if (operator == Operator.UNEQUAL) 
            return !this.value.equals(value);
        return false;
    }
    
}
