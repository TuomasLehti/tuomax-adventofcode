package fi.tuomax.adventofcode.year2017.day08;

public class Instruction 
{

    private String changeRegisterName = "";

    private Integer changeOffset = 0;

    private String conditionRegisterName = "";

    private Operator operator;

    private Integer conditionValue = 0;

    public Instruction(String input)
    {
        String[] parts = input.split(" ");
        changeRegisterName = parts[0];
        changeOffset = Integer.valueOf(parts[2]);
        if (parts[1].equals("dec")) {
            changeOffset *= -1;
        }
        conditionRegisterName = parts[4];
        operator = Operator.fromString(parts[5]);
        conditionValue = Integer.valueOf(parts[6]);
    }
    
    public void execute(RegisterArray registers)
    {
        if (registers.getRegister(conditionRegisterName).compare(operator, conditionValue))
            registers.getRegister(changeRegisterName).changeValue(changeOffset);
    }

}
