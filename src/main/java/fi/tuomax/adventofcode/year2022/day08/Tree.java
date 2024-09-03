package fi.tuomax.adventofcode.year2022.day08;

public class Tree 
{

    private Integer height;

    public Integer getHeight() 
    {
        return height;
    }

    private Boolean visible = false;

    public Boolean isVisible() 
    {
        return visible;
    }

    public void setVisible()
    {
        visible = true;
    }

    public Tree(Integer height)
    {
        this.height = height;
    }
    
}
