package it.unibo.generics.graph.Impl;

import java.util.*;

import it.unibo.generics.graph.abstracts.AbstractSearch;
import it.unibo.generics.graph.api.Graph;

public class BreadthFirstSearch<N> extends AbstractSearch<N> {

    public BreadthFirstSearch(){
        super();
    }
    
    public List<N> getPath(Graph<N> g, N source, N target) {
        
        final Deque<N> queue = new ArrayDeque<>();
        queue.add(source);
        this.addVisited(source);

        while(!queue.isEmpty()){
            final N firstNode = queue.remove();        
            this.addNodeOnPath(firstNode);
            this.setAdiacents(g.linkedNodes(firstNode));
            
            for (N node : this.getAdiacents()) {
                if(!this.getVisited().contains(node)){
                    if(node.equals(target)){
                        this.addNodeOnPath(target);
                        return this.getFinalPath();
                    }
                }                     
            }
            this.addVisited(this.getAdiacents());
            queue.addLast(this.getAdiacents().iterator().hasNext() ? this.getAdiacents().iterator().next() : null);   
                         
        }
        return this.getFinalPath();
    }
    
}
