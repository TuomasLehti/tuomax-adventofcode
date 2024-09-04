package fi.tuomax.adventofcode.year2022.day09;

import fi.tuomax.adventofcode.commons.Direction;

public record Motion(
    Direction direction,
    Integer amount
)
{

    public static Motion fromAocInput(String input)
    {
        Direction direction = Direction.fromString(input.split(" ")[0]);
        Integer amount = Integer.valueOf(input.split(" ")[1]);
        return new Motion(direction, amount);
    }

}
