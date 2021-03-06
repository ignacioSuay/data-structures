package com.ignaciosuay.datastructure.graph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Graph<V, E> {

    private List<Vertex<V, E>> vertices = new ArrayList<>();
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

    public void addVertex(Vertex<V, E> vertex) {
        vertices.add(vertex);
    }

    public void addListVertex(List<Vertex<V, E>> vertexList) {
        vertices.addAll(vertexList);
    }

    public void insertEdge(Vertex u, Vertex v, E element) {
        insertEdge(u, v, element, 0);
    }
    public void insertEdge(Vertex u, Vertex v, E element, double weight) {
        Edge<E> edge = new Edge<>();
        edge.setElement(element);
        edge.setWeight(weight);
        edge.setStart(u);
        edge.setEnd(v);
        v.getEndpoint().put(u, edge);
        u.getEndpoint().put(v, edge);
    }
}
