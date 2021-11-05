package com.company;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@ToString
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdjencyMatrix {

    /**
     * Contains weight of edges
     */
    @Builder.Default @NonNull
    final List<List<Integer>> adjencyMatrix = new ArrayList<>();

    /**
     * Outgoing vertexes count
     */
    @Builder.Default
    int sizeX = 0;

    /**
     * Incoming vertexes count
     */
    @Builder.Default
    int sizeY = 0;

    protected void add(int weight, int outGoing, int inComing){
        if (adjencyMatrix.size() <= outGoing)
            IntStream.range(adjencyMatrix.size(), outGoing + 1).forEach(x -> adjencyMatrix.add(new ArrayList<>()));
        if (adjencyMatrix.get(outGoing).size() <= inComing)
            IntStream.range(adjencyMatrix.get(outGoing).size(), inComing).forEach(y -> adjencyMatrix.get(outGoing).add(null));

        sizeX = (sizeX > outGoing + 1) ? sizeX : outGoing + 1;
        sizeY = (sizeY > inComing + 1) ? sizeY : inComing + 1;

        adjencyMatrix.get(outGoing).add(inComing, weight);
    }

    protected Integer get(int outGoing, int inComing){
        if (adjencyMatrix.size() <= outGoing)
            return null;
        if (adjencyMatrix.get(outGoing).size() <= inComing)
            return null;
        return adjencyMatrix.get(outGoing).get(inComing);
    }

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
