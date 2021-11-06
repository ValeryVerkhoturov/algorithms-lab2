package com.company;

public class Main {

    public static void main(String[] args) {
        WightedDirectedGraph graph = WightedDirectedGraph.builder().build();
        graph.addEdge(40, 1, 4);
        graph.addEdge(30, 2, 3);
        graph.addEdge(20, 3, 2);
        graph.addEdge(10, 6, 1);
        System.out.println(graph);
        System.out.println(graph.getEdge(3, 2));
        System.out.println(graph.getEdge(5, 0));
        System.out.println(graph.maxVertexValue());

    }
}
