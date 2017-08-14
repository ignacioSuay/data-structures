package com.ignaciosuay.datastructure.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Graph<V, E> {

    private List<Vertex<V>> vertices = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public Edge getEdge(Vertex start, Vertex end) {
        return (Edge) start.getEndpoint().get(end);
    }

    public Vertex getOpposite(Vertex start, Edge edge) throws IllegalArgumentException {
        if (edge.getStart() == start) {
            return edge.getEnd();
        } else if (edge.getEnd() == start) {
            return edge.getStart();
        }

        throw new IllegalArgumentException("v is not incident to this age");
    }

    public void insertVertex(V element) {
        Vertex<V> vertex = new Vertex<V>();
        vertex.setElement(element);
        vertices.add(vertex);
    }

    public void insertEdge(Vertex u, Vertex v, E element) {
        Edge<E> edge = new Edge<>();
        edge.setStart(u);
        edge.setEnd(v);
        v.getEndpoint().put(u, edge);
        u.getEndpoint().put(v, edge);
    }

}
