package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void breadthFirstSearch(){
        assertEquals(1, Search.breadthFirstSearch(graph,1,2));
        assertEquals(3, Search.breadthFirstSearch(graph,3,2));
        assertEquals(1, Search.breadthFirstSearch(graph,4,2));
        assertEquals(6, Search.breadthFirstSearch(graph,5,2));
    }

    @Test
    public void vertexEccentricity(){
        assertEquals(0, Search.vertexEccentricity(graph, 1));
        assertEquals(6, Search.vertexEccentricity(graph, 2));
        assertEquals(8, Search.vertexEccentricity(graph, 3));
        assertEquals(5, Search.vertexEccentricity(graph, 4));
        assertEquals(7, Search.vertexEccentricity(graph, 5));
    }
}
