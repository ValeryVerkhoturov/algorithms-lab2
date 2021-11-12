package com.company;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class WightedDirectedGraph extends AdjencyMatrix{

    /**
     * Add weight in {@link AdjencyMatrix}.
     *
     * @param weight value on edge
     * @param outGoing start vertex
     * @param inComing finish vertex
     */
    public void addEdge(int weight, int outGoing, int inComing){
        add(weight, outGoing, inComing);
    }

    /**
     * @param outGoing start vertex
     * @param inComing finish vertex
     * @return weight of edge
     */
    public Integer getEdge(int outGoing, int inComing){
        return get(outGoing, inComing);
    }

    public void deleteEdge(int outGoing, int inComing){
        delete(outGoing, inComing);
    }

    /**
     * @return size of square {@link AdjencyMatrix}
     */
    public int matrixSize(){
        return size();
    }

    /**
     * Count from zero to max vertex in {@link AdjencyMatrix}
     * @return max index + 1 from {@link AdjencyMatrix}
     */
    public int matrixSideSize(){
        return sideSize();
    }
}
