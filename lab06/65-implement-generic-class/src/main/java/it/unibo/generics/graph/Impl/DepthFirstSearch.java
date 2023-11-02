package it.unibo.generics.graph.Impl;

import java.util.*;

import it.unibo.generics.graph.abstracts.AbstractSearch;
import it.unibo.generics.graph.api.Graph;

public class DepthFirstSearch<N> extends AbstractSearch<N> {

    public DepthFirstSearch(){
        super();
    }

    public List<N> getPath(Graph<N> g, N source, N target) {
        
        final Stack<N> stack = new Stack<>();
        stack.add(source);

        while(!stack.isEmpty()){
            final N firstNode = stack.remove();
            if(!this.getVisited().contains(firstNode)){
                this.addNodeOnPath(firstNode);
                Set<N> nodes = g.linkedNodes(firstNode);
                this.getVisited().add(firstNode);
                
                if(nodes.contains(target)){
                    this.addNodeOnPath(target);
                    return this.getFinalPath();
                }
                stack.push(;
            }        
          
        }
        return this.getFinalPath();
        
        return null;
    }
    
}