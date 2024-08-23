package fi.tuomax.adventofcode.commons.pathfinding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTravellingSalesman 
{

    @Test
    public void test()
    {
        Graph graph = new Graph();

        graph.addNodesAndUndirectedEdge("Helsinki",  "Pori", 237);
        graph.addNodesAndUndirectedEdge("Helsinki",  "Tampere", 179);
        graph.addNodesAndUndirectedEdge("Pori",  "Tampere", 109);

        // Hki - Pri - Tre 237 + 109 = 346
        // Hki - Tre - Pri 179 + 109 = 288
        // Pri - Tre - Hki 109 + 179 = 288
        // Pri - Hki - Tre 237 + 179 = 416
        // Tre - Hki - Pri 179 + 237 = 416
        // Tre - Pri - Hki 109 + 237 = 346

        assertEquals(288, (int) TravellingSalesmanBruteforce.minDistance(graph));
        assertEquals(416, (int) TravellingSalesmanBruteforce.maxDistance(graph));
    }

    @Test
    public void test_FixedStartingPoint()
    {
        Graph graph = new Graph();

        graph.addNodesAndUndirectedEdge("Helsinki",  "Pori", 237);
        graph.addNodesAndUndirectedEdge("Pori",  "Helsinki", 237);
        graph.addNodesAndUndirectedEdge("Helsinki",  "Tampere", 179);
        graph.addNodesAndDirectedEdge("Tampere",  "Helsinki", 179);
        graph.addNodesAndUndirectedEdge("Helsinki", "Jyväskylä", null);
        graph.addNodesAndUndirectedEdge("Pori",  "Tampere", 109);
        graph.addNodesAndUndirectedEdge("Tampere",  "Pori", 109);
    }

}
