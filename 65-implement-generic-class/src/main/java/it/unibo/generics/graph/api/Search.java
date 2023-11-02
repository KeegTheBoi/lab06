package it.unibo.generics.graph.api;

import java.util.List;

public interface Search<N> {
    public List<N> getPath(Graph<N> g, N source, N target);
}
