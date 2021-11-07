
package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class WightedDirectedGraphTest extends Assert {
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
    public void correctMatrix(){
        Integer[][] reference = {{}, {null, null, 3, 2}, {}, {null, null, 5, null, 4, 6}, {}, {null, 1, 7}};
        assertArrayEquals(graph.getAdjencyMatrix().stream().map(List::toArray).toArray(), reference);
    }

    @Test
    public void getEdges(){
        assertEquals((int)graph.getEdge(5, 1), 1);
        assertEquals((int)graph.getEdge(1, 3), 2);
        assertEquals((int)graph.getEdge(1, 2), 3);
        assertEquals((int)graph.getEdge(3, 4), 4);
        assertEquals((int)graph.getEdge(3, 2), 5);
        assertEquals((int)graph.getEdge(3, 5), 6);
        assertEquals((int)graph.getEdge(5, 2), 7);
    }

    @Test
    public void matrixSize(){
        int referenceMaxVertexValue = 6;
        assertEquals(graph.matrixSize(), referenceMaxVertexValue);
    }

    @Test
    public void getVertexes(){
        assertEquals(graph.getNeighbors(0), Set.of());
        assertEquals(graph.getNeighbors(1), Set.of(3, 2));
        assertEquals(graph.getNeighbors(2), Set.of());
        assertEquals(graph.getNeighbors(3), Set.of(5, 2, 4));
        assertEquals(graph.getNeighbors(4), Set.of());
        assertEquals(graph.getNeighbors(5), Set.of(1, 2));
    }
}