package it.unibo.generics.graph.abstracts;

import java.util.*;

import it.unibo.generics.graph.api.Search;
import it.unibo.generics.graph.api.Graph;

public abstract class AbstractSearch<N> implements Search<N>{

    private final Set<N> visited;
    private final List<N> finalPath;
    private Set<N> adiacents;

    

    public AbstractSearch(){
        this.visited = new HashSet<>();
        this.finalPath = new ArrayList<>();
    }

    protected void setAdiacents(Set<N> adiacents) {
        this.adiacents = adiacents;
    }

    protected Set<N> getAdiacents() {
        return adiacents;
    }


    protected Set<N> getVisited(){
        return this.visited;
    }

    protected List<N> getFinalPath() {
        return this.finalPath;
    }

    protected void addNodeOnPath(N node){
        this.finalPath.add(node);
    }

    protected void addVisited(N node){
        this.visited.add(node);
    }

    protected void addVisited(Collection<N> nodes){
        this.visited.addAll(nodes);
    }


    public abstract List<N> getPath(Graph<N> g, N source, N target); 
}
