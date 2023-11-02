package it.unibo.generics.graph.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {

    Map<N, Set<N>> nodeGraph;

    public GraphImpl(){
        this.nodeGraph = new HashMap<>();
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
        final List<N> path = new ArrayList<>();
        final Set<N> visited = new HashSet<>();
        final Queue<N> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()){
            final N firstNode = queue.remove();
            final Set<N> nodiLinkati = this.nodeGraph.get(firstNode);
            if(visited.containsAll(nodiLinkati)){
                continue;
            }
            path.add(firstNode);
            
            visited.addAll(nodiLinkati);
            for (N n : nodiLinkati) {
                if(n.equals(target)){
                    path.add(target);
                    return path;
                }
                queue.addAll(this.nodeGraph.get(firstNode));
            }

        }

        return path;
    }
    
}
