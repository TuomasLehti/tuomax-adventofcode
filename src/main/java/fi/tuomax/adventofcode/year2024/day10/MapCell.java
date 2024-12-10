package fi.tuomax.adventofcode.year2024.day10;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Coordinates;

public class MapCell 
{

    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    private Integer elevation;

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer height) {
        this.elevation = height;
    }

    private Boolean visited = false;
    

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    private Set<MapCell> reachableNeighbors = new HashSet<>();

    public Set<MapCell> getReachableNeighbors() 
    {
        return reachableNeighbors;
    }

    public void addReachableNeighbor(MapCell reachableNeighbor)
    {
        reachableNeighbors.add(reachableNeighbor);
    }

    public MapCell(Coordinates coordinates, Integer height) 
    {
        this.coordinates = coordinates;
        this.elevation = height;
    }
    
}
