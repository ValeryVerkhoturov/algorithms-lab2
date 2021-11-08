package com.company;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.IntStream;

@UtilityClass
public class Search {

    public Integer breadthFirstSearch(WightedDirectedGraph graph, int source, int destination){
        Integer[] d = new Integer[graph.matrixSideSize()];
        IntStream.range(0, graph.matrixSideSize()).forEach(i -> d[i] = null);
        d[source] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for (int neighbour:graph.getNeighbors(v)) {
                if (d[neighbour] == null){
                    d[neighbour] = d[v] + graph.get(v, neighbour);
                    queue.offer(neighbour);
                }
            }
        }
        return d[destination];
    }

    public Integer vertexEccentricity(WightedDirectedGraph graph, Integer destination){
        return graph.getVertexes().stream().map(source -> breadthFirstSearch(graph, source, destination)).filter(Objects::nonNull).filter(v -> v != 0).max(Comparator.comparing(v -> v)).orElse(null);
    }
}

