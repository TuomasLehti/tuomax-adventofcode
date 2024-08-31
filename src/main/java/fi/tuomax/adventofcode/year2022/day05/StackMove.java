package fi.tuomax.adventofcode.year2022.day05;

public record StackMove(
    Integer amount,
    Integer from,
    Integer to
) {

    public static StackMove fromInput(String input)
    {
        final Integer AMOUNT_IDX = 1;
        final Integer FROM_IDX = 3;
        final Integer TO_IDX = 5;
        String[] parts = input.split(" ");
        return new StackMove(
            Integer.valueOf(parts[AMOUNT_IDX]),
            Integer.valueOf(parts[FROM_IDX]),
            Integer.valueOf(parts[TO_IDX])
        );
    }
    
}
