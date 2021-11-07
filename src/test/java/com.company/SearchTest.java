package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchTest extends Assert {
    private final WightedDirectedGraph graph = WightedDirectedGraph.builder().build();

    @Before
    public void addEdges(){
        graph.addEdge(1, 5, 1);
        graph.addEdge(2, 1, 3);
        graph.addEdge(3, 1, 2);
        graph.addEdge(4, 3, 4);
        graph.addEdge(5, 3, 2);
        graph.addEdge(6, 3, 5);
        graph.addEdge(7, 5, 2);
    }

    @Test
    public void breadthFirstSearch(){
    }
}
