package com.company;

import lombok.experimental.UtilityClass;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.IntStream;

@UtilityClass
public class Search {

//    public int breadthFirstSearch(WightedDirectedGraph graph, int source, int destination){
//        Integer[] d = new Integer[graph.matrixSideSize()];
//        int[] mark = new int[graph.matrixSideSize()];
//        IntStream.range(0, graph.matrixSideSize()).forEach(i ->{
//            d[i] = null;
//            mark[i] = 0;
//        });
//        d[source] = 0;
//        mark[source] = 1;
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer(source);
//        while(!queue.isEmpty()) {
//            int v = queue.poll();
//            for (int neighbour:graph.getNeighbors(v)) {
//                if (mark[neighbour] == 0){
//                    d[neighbour] = d[v] + graph.get(v, neighbour);
//                    mark[neighbour] = 1;
//                    queue.offer(neighbour);
//                }
//            }
//        }
//        return d[destination];
//    }
    public int breadthFirstSearch(WightedDirectedGraph graph, int source, int destination){
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
}
