package com.company;

import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString(callSuper = true)
@SuperBuilder
public class WightedDirectedGraph extends AdjencyMatrix{

    public void addEdge(int weight, int outGoing, int inComing){
        add(weight, outGoing, inComing);
    }

    public Integer getWeightOfEdge(int outGoing, int inComing){
        return get(outGoing, inComing);
    }

    public int maxVertexValue(){
        return getVertexes().stream().mapToInt(v -> v).max().orElseThrow();
    }
}
