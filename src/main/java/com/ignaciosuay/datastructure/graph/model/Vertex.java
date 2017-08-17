package com.ignaciosuay.datastructure.graph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vertex<V, E> {
    private V element;
    private Map<Vertex<V, E>, Edge<E>> endpoint = new HashMap<>();

}
