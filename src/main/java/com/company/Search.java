package com.company;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.IntStream;

@UtilityClass
public class Search {

    public Integer breadthFirstSearch(WightedDirectedGraph graph, int source, int destination){
        Integer[] routeTo = new Integer[graph.matrixSideSize()];
        Arrays.fill(routeTo, null);
        routeTo[source] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while(!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbour:graph.getNeighbors(currentVertex)) {
                if (routeTo[neighbour] == null){
                    routeTo[neighbour] = routeTo[currentVertex] + graph.get(currentVertex, neighbour);
                    queue.offer(neighbour);
                }
            }
        }
        return routeTo[destination];
    }

    /**
     * @param graph adjency matrix source
     * @param destination graph center
     * @return max way to center vertex
     */
    public Integer vertexEccentricity(WightedDirectedGraph graph, Integer destination){
        return graph.getVertexes().stream().map(source -> breadthFirstSearch(graph, source, destination)).filter(Objects::nonNull).filter(v -> v != 0).max(Comparator.comparing(v -> v)).orElse(null);
    }

    /**
     * @param graph adjency matrix source
     * @return minimum vertex eccentricity from all vertexes in graph
     */
    public Integer graphEccentricity(WightedDirectedGraph graph) {
        return graph.getVertexes().stream().map(v -> vertexEccentricity(graph, v)).filter( Objects::nonNull).min(Comparator.comparing(v -> v)).orElse(null);
    }
}

