package com.company;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ToString
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
     * @return weight value, if it exsists or null, if it does not exist
     */
    protected Integer get(int outGoing, int inComing){
        try {
            return adjencyMatrix.get(outGoing).get(inComing);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    /**
     * @param outGoing vertex
     * @return vertexes, outGoing vertex is directed to
     */
    public Set<Integer> getNeighbors(int outGoing){
        return adjencyMatrix.get(outGoing).stream().filter(Objects::nonNull).collect(Collectors.toSet());
    }

    /**
     * @return set of vertexes in {@link #adjencyMatrix}, who is connected with other vertexes
     */
    private Set<Integer> getVertexes(){
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
     * @return max index of {@link #adjencyMatrix} + 1
     */
    protected int size(){
        return getVertexes().stream().mapToInt(v -> v).max().orElseThrow() + 1;
    }
}
