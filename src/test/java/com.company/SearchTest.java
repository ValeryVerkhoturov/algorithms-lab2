package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class SearchTest extends Assert {
    private final WightedDirectedGraph graph = WightedDirectedGraph.builder().build();

    @Before
    public void addEdges(){
        graph.addEdge(1, 1, 2);
        graph.addEdge(2, 2, 3);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 3);
        graph.addEdge(1, 4, 2);
        graph.addEdge(4, 3, 5);
        graph.addEdge(5, 5, 4);
    }

    @Test
    public void getNeighbours(){
        assertEquals(Set.of(2), graph.getNeighbors(1));
        assertEquals(Set.of(3), graph.getNeighbors(2));
        assertEquals(Set.of(4, 5), graph.getNeighbors(3));
        assertEquals(Set.of(2, 3), graph.getNeighbors(4));
        assertEquals(Set.of(4), graph.getNeighbors(5));
    }

    @Test
    public void vertexEccentricity(){
        assertNull(Search.vertexEccentricity(graph, 1));
        assertEquals((Integer) 6, Search.vertexEccentricity(graph, 2));
        assertEquals((Integer) 8, Search.vertexEccentricity(graph, 3));
        assertEquals((Integer) 5, Search.vertexEccentricity(graph, 4));
        assertEquals((Integer) 7, Search.vertexEccentricity(graph, 5));
    }
}
