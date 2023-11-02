package it.unibo.generics.graph.Impl;

import java.util.*;

import it.unibo.generics.graph.abstracts.AbstractSearch;
import it.unibo.generics.graph.api.Graph;

public class BreadthFirstSearch<N> extends AbstractSearch<N> {

    public BreadthFirstSearch(){
        super();
    }
    
    public List<N> getPath(Graph<N> g, N source, N target) {
        
        final Queue<N> queue = new PriorityQueue<>();
        queue.add(source);

        while(!queue.isEmpty()){
            final N firstNode = queue.remove();
            if(!this.getVisited().contains(firstNode)){
                this.addNodeOnPath(firstNode);
                Set<N> nodes = g.linkedNodes(firstNode);
                this.getVisited().add(firstNode);
                
                if(nodes.contains(target)){
                    this.addNodeOnPath(target);
                    return this.getFinalPath();
                }
                queue.addAll(nodes);
            }        
          
        }
        return this.getFinalPath();
    }
    
}
