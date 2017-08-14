package com.ignaciosuay.datastructure.graph;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vertex<V> {
    private V element;
    private Map<Vertex, Edge> endpoint = new HashMap<>();


    public V getElement() {
        return this.element;
    }

    public Map<Vertex, Edge> getEndpoint() {
        return this.endpoint;
    }
}
