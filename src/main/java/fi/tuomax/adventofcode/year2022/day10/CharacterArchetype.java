package fi.tuomax.adventofcode.year2022.day10;

public class CharacterArchetype 
implements Comparable<CharacterArchetype>
{

    private Character character;

    public Character getCharacter() 
    {
        return character;
    }

    private String pixels;

    private Double samenessScore;

    public CharacterArchetype(Character character, String pixels)
    {
        this.character = character;
        this.pixels = pixels;
    }

    public void compareAgainst(String otherPixels)
    {
        int pixelCount = 0;
        for (int i = 0; i < pixels.length(); i++) {
            if (pixels.charAt(i) == otherPixels.charAt(i)) {
                pixelCount++;
            }
        }
        samenessScore = (double) pixelCount / pixels.length();
    }

    @Override
    public int compareTo(CharacterArchetype o) 
    {
        return this.samenessScore.compareTo(o.samenessScore);
    }

    public String toString()
    {
        return String.format("[%s: %.3f]", character, samenessScore);
    }
    
}
