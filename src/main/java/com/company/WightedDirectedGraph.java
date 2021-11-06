package com.company;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class WightedDirectedGraph extends AdjencyMatrix{

        /**
         * Add weight in adjecy matrix.
         *
         * @param weight matrix value
         * @param outGoing start vertex
         * @param inComing finish vertex
         */
        public void addEdge(int weight, int outGoing, int inComing){
        add(weight, outGoing, inComing);
    }

    /**
     * @param inComing start vertex
     * @param outGoing finish vertex
     * @return weight of edge
     */
    public Integer getEdge(int outGoing, int inComing){
        return get(outGoing, inComing);
    }

    /**
     * @return max vertex number
     */
    public int maxVertexValue(){
        return getVertexes().stream().mapToInt(v -> v).max().orElseThrow();
    }
}
