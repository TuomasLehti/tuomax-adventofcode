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
        graph.addNodesAndUndirectedEdge("Helsinki",  "Tampere", 179);
        graph.addNodesAndUndirectedEdge("Helsinki", "Jyväskylä", 269);
        graph.addNodesAndUndirectedEdge("Pori",  "Tampere", 109);
        graph.addNodesAndUndirectedEdge("Tampere", "Jyväskylä", 155);
        graph.addNodesAndUndirectedEdge("Pori", "Jyväskylä", 263);

        // Hki - Pri - Tre - Jy     237 + 109 + 155 = 501
        // Hki - Pri - Jy  - Tre    237 + 263 + 155 = 655
        // Hki - Tre - Pri - Jy     179 + 109 + 263 = 551
        // Hki - Tre - Jy  - Pri    179 + 155 + 263 = 597
        // Hki - Jy  - Tre - Pri    269 + 155 + 109 = 533
        // Hki - Jy  - Pri - Tre    269 + 263 + 109 = 641

        TravellingSalesmanBruteforce.fixedStartingNode = "Helsinki";
        assertEquals(501, (int) TravellingSalesmanBruteforce.minDistance(graph));
        assertEquals(655, (int) TravellingSalesmanBruteforce.maxDistance(graph));
    }

    @Test
    public void test_ReturnToStartingNode()
    {
        Graph graph = new Graph();

        graph.addNodesAndUndirectedEdge("Helsinki",  "Pori", 237);
        graph.addNodesAndUndirectedEdge("Helsinki",  "Tampere", 179);
        graph.addNodesAndUndirectedEdge("Helsinki", "Jyväskylä", 269);
        graph.addNodesAndUndirectedEdge("Pori",  "Tampere", 109);
        graph.addNodesAndUndirectedEdge("Tampere", "Jyväskylä", 155);
        graph.addNodesAndUndirectedEdge("Pori", "Jyväskylä", 263);

        // Hki - Pri - Tre - Jy  - Hki   237 + 109 + 155 + 269 = 770
        // Hki - Pri - Jy  - Tre - Hki   237 + 263 + 155 + 179 = 834
        // Hki - Tre - Pri - Jy  - Hki   179 + 109 + 263 + 269 = 820
        // Hki - Tre - Jy  - Pri - Hki   179 + 155 + 263 + 237 = 834
        // Hki - Jy  - Tre - Pri - Hki   269 + 155 + 109 + 237 = 770 
        // Hki - Jy  - Pri - Tre - Hki   269 + 263 + 109 + 179 = 820

        TravellingSalesmanBruteforce.fixedStartingNode = "Helsinki";
        TravellingSalesmanBruteforce.returnToStartingNode = true;
        assertEquals(770, (int) TravellingSalesmanBruteforce.minDistance(graph));
        assertEquals(834, (int) TravellingSalesmanBruteforce.maxDistance(graph));
    }

}
