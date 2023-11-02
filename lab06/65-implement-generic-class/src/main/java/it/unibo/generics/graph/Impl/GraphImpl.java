package it.unibo.generics.graph.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.Search;

public class GraphImpl<N> implements Graph<N> {

    Map<N, Set<N>> nodeGraph;
    Search<N> strategySearch;

    public GraphImpl(Search<N> search){
        this.nodeGraph = new HashMap<>();
        strategySearch = search;
    }

    public Map<N, Set<N>> getNodeGraph() {
        return nodeGraph;
    } 

    public void addNode(N node) {
        this.nodeGraph.putIfAbsent(node, new HashSet<>());
        
    }

    public void addEdge(N source, N target) {
        if(this.nodeGraph.containsKey(source)){
           this.nodeGraph.get(source).add(target);
        }        
    }


    public Set<N> nodeSet() {
        return this.nodeGraph.keySet();
    }


    public Set<N> linkedNodes(N node) {
        return this.nodeGraph.getOrDefault(node, Collections.emptySet());
    }


    public List<N> getPath(N source, N target) {
        return strategySearch.getPath(this, source, target);
    }
    
}
