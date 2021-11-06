package com.company;

import lombok.Builder;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@ToString
@SuperBuilder
public class AdjencyMatrix {

    /**
     * Matrix contains weight of edges.<br>
     * If weight does not exist contains null or nothing.
     */
    @Builder.Default
    private final List<List<Integer>> adjencyMatrix = new ArrayList<>();

    /**
     * Extend matrix with nulls, if matrix is smaller than outGoind or inComing coordinates.<br>
     * Add weight.
     *
     * @param weight value of matrix cell
     * @param outGoing x coordinate
     * @param inComing y coordinate
     */
    protected void add(int weight, int outGoing, int inComing){
        // Extend matrix
        if (adjencyMatrix.size() <= outGoing)
            IntStream.range(adjencyMatrix.size(), outGoing + 1).forEach(x -> adjencyMatrix.add(new ArrayList<>()));
        if (adjencyMatrix.get(outGoing).size() <= inComing)
            IntStream.range(adjencyMatrix.get(outGoing).size(), inComing).forEach(y -> adjencyMatrix.get(outGoing).add(null));

        // Add value
        adjencyMatrix.get(outGoing).add(inComing, weight);
    }

    /**
     * Get weight of edge from outGoing vertex to inComing vertex.
     *
     * @param outGoing x coordinate
     * @param inComing y coordinate
     * @return value, if it exsists and null, if it does not exist
     */
    protected Integer get(int outGoing, int inComing){
        // Value does not exists, because matrix x size is smaller
        if (adjencyMatrix.size() <= outGoing)
            return null;

        // Value does not exists, because matrix y size with current x coordinate is smaller
        if (adjencyMatrix.get(outGoing).size() <= inComing)
            return null;

        return adjencyMatrix.get(outGoing).get(inComing);
    }

    /**
     * @return vertexes, who are connected with edges
     */
    protected Set<Integer> getVertexes(){
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
}
