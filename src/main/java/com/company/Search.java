package com.company;

import lombok.experimental.UtilityClass;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.IntStream;

@UtilityClass
public class Search {

    public int breadthFirstSearch(WightedDirectedGraph graph, int source, int destination){
        Integer[] d = new Integer[graph.matrixSize()];
        int[] mark = new int[graph.matrixSize()];
        IntStream.range(0, graph.matrixSize()).forEach(i ->{
            d[i] = null;
            mark[i] = 0;
        });
        d[source] = 0;
        mark[source] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < graph.getAdjencyMatrix().size(); i++) {
                if (graph.get(v, i) != null && mark[graph.get(v, i)] == 0){
                    d[graph.get(v, i)] = d[v] + 1;
                    mark[graph.get(v, i)] = 1;
                    queue.offer(graph.get(v, i));
                }
            }
        }
        return d[destination];
    }
}
