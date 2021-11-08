
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
        assertArrayEquals(reference, graph.getAdjencyMatrix().stream().map(List::toArray).toArray());
    }

    @Test
    public void getEdges(){
        assertEquals(1, (int)graph.getEdge(5, 1));
        assertEquals(2, (int)graph.getEdge(1, 3));
        assertEquals(3, (int)graph.getEdge(1, 2));
        assertEquals(4, (int)graph.getEdge(3, 4));
        assertEquals(5, (int)graph.getEdge(3, 2));
        assertEquals(6, (int)graph.getEdge(3, 5));
        assertEquals(7, (int)graph.getEdge(5, 2));
    }

    @Test
    public void matrixSize(){
        int referenceMatrixSize = 36;
        assertEquals(referenceMatrixSize, graph.matrixSize());
    }

    @Test
    public void matrixSideSize(){
        int referenceMatrixSideSize = 6;
        assertEquals(referenceMatrixSideSize, graph.matrixSideSize());
    }

    @Test
    public void getNeighborVertexes(){
        assertEquals(Set.of(), graph.getNeighbors(0));
        assertEquals(Set.of(3, 2), graph.getNeighbors(1));
        assertEquals(Set.of(), graph.getNeighbors(2));
        assertEquals(Set.of(5, 2, 4), graph.getNeighbors(3));
        assertEquals(Set.of(), graph.getNeighbors(4));
        assertEquals(Set.of(1, 2), graph.getNeighbors(5));
    }

    @Test
    public void getVertexes(){
        assertEquals(Set.of(1, 2, 3, 4, 5), graph.getVertexes());
    }
}