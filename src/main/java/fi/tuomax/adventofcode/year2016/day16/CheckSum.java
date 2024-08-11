package fi.tuomax.adventofcode.year2016.day16;

public class CheckSum 
{

    public static String calculate(String input)
    {
        if ((input.length() % 2) == 1) return input;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i += 2) {
            if (input.charAt(i) == input.charAt(i + 1))
                sb.append("1");
            else
                sb.append("0");
        }
        return calculate(sb.toString());
    }
    
}
