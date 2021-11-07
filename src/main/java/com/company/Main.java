package com.company;

public class Main {

    public static void main(String[] args) {
        WightedDirectedGraph graph = WightedDirectedGraph.builder().build();

        graph.addEdge(1, 1, 2);
        graph.addEdge(2, 2, 3);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 3);
        graph.addEdge(1, 4, 2);
        graph.addEdge(4, 3, 5);
        graph.addEdge(5, 5, 4);
        System.out.println(graph.getVertexes());
        System.out.println(Search.vertexEccentricity(graph, 1));
    }
}
