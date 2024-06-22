package fi.tuomax.adventofcode.year2015.day21;

public record Weapon(
    String name,
    Integer price,
    Integer damage,
    Integer armor
) {
    
    public static Weapon fromString(String input)
    {
        String[] parts = input.split("\\s{2,}");
        return new Weapon(
            parts[0],
            Integer.valueOf(parts[1]), 
            Integer.valueOf(parts[2]), 
            Integer.valueOf(parts[3])
        );
    }

    

}
