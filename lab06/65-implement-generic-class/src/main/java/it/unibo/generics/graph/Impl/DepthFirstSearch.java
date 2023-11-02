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
            final N firstNode = stack.pop();
            if(!this.getVisited().contains(firstNode)){
                this.addNodeOnPath(firstNode);
                this.setAdiacents(g.linkedNodes(firstNode));
                this.addVisited(firstNode);

                if(firstNode.equals(target)){
                    return this.getFinalPath();
                }
                stack.addAll(this.getAdiacents());
            }        
          
        }
        return this.getFinalPath();
    }
    
}