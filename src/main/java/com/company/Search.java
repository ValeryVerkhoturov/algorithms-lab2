package com.company;

import lombok.experimental.UtilityClass;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

@UtilityClass
public class Search {

    public void breadthFirstSearch(WightedDirectedGraph graph, int source, int destination){
        Integer[] d = new Integer[graph.maxVertexValue()];
        IntStream.range(0, d.length).forEach(i -> d[i] = null);
        d[source] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while (!queue.isEmpty()){
            int v = queue.poll();

        }
    }
}
