package it.unibo.generics.graph.abstracts;

import java.util.*;

import it.unibo.generics.graph.api.Search;
import it.unibo.generics.graph.api.Graph;

public abstract class AbstractSearch<N> implements Search<N>{

    private final Set<N> visited;
    private final List<N> finalPath;


    public AbstractSearch(){
        this.visited = new HashSet<>();
        this.finalPath = new ArrayList<>();
    }

    protected Set<N> getVisited(){
        return this.visited;
    }

    protected List<N> getFinalPath() {
        return this.finalPath;
    }

    public void addNodeOnPath(N node){
        this.finalPath.add(node);
    }


    public abstract List<N> getPath(Graph<N> g, N source, N target); 
}
