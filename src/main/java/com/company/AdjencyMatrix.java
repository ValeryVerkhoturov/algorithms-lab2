package com.company;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.*;
import java.util.stream.IntStream;

@Data
@SuperBuilder
public class AdjencyMatrix {

    /**
     * Matrix contains weight of edges.<br>
     * If weight does not exist contains null or nothing.<br>
     * First index - outgoing vertex.<br>
     * Second index - incoming vertex.
     */
    @Getter
    @Builder.Default
    private final List<List<Integer>> adjencyMatrix = new ArrayList<>();

    /**
     * Extend matrix with nulls, if matrix is smaller than outGoind or inComing coordinates.<br>
     * Add weight.
     *
     * @param weight value of {@link #adjencyMatrix} cell
     * @param outGoing (first index of matrix)
     * @param inComing (second index of matrix)
     */
    protected void add(int weight, int outGoing, int inComing){
        // Extend matrix
        if (adjencyMatrix.size() <= outGoing)
            IntStream.range(adjencyMatrix.size(), outGoing + 1).forEach(x -> adjencyMatrix.add(x, new ArrayList<>()));
        if (adjencyMatrix.get(outGoing).size() <= inComing)
            IntStream.range(adjencyMatrix.get(outGoing).size(), inComing + 1).forEach(y -> adjencyMatrix.get(outGoing).add(y, null));

        // Add value
        adjencyMatrix.get(outGoing).set(inComing, weight);
    }

    /**
     * Get weight of edge from outGoing vertex to inComing vertex.
     *
     * @param outGoing vertex (first index of {@link #adjencyMatrix})
     * @param inComing vertex (second index of {@link #adjencyMatrix})
     * @return weight value, if it exsists
     *      or null, if it does not exist and not over existing
     *      maximum outgoing vertex and maximum incoming vertex
     * @throws IndexOutOfBoundsException if the vertex is over existing vertexes
     */
    protected Integer get(int outGoing, int inComing){
        return adjencyMatrix.get(outGoing).get(inComing);
    }

    /**
     * @param outGoing vertex
     * @return vertexes, outGoing vertex is directed to
     */
    public Set<Integer> getNeighbors(int outGoing){
        Set<Integer> output = new LinkedHashSet<>();
        IntStream.range(0, adjencyMatrix.get(outGoing).size()).forEach(i -> {
            if (adjencyMatrix.get(outGoing).get(i) != null)
                output.add(i);
        });
        return output;
    }

    /**
     * @return vertexes in {@link #adjencyMatrix}, who is connected with other vertexes
     */
    public Set<Integer> getVertexes(){
        Set<Integer> vertexes = new LinkedHashSet<>();
        IntStream.range(0, adjencyMatrix.size()).forEach(x -> {
            if (adjencyMatrix.get(x).size() != 0)
                vertexes.add(x);
            IntStream.range(0, adjencyMatrix.get(x).size()).forEach(y -> {
                if (adjencyMatrix.get(x).get(y) != null)
                    vertexes.add(y);
            });
        });
        return vertexes;
    }

    /**
     * @return size of {@link #adjencyMatrix}
     */
    protected int size(){
        return (int) Math.pow(sideSize(), 2);
    }

    /**
     * @return maximum size of sides in {@link #adjencyMatrix}
     */
    protected int sideSize(){
        return getVertexes().stream().mapToInt(v -> v).max().orElseThrow() + 1;
    }
}
