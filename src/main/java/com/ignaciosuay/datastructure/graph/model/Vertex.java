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
public class Vertex<V> {
    private V element;
    private Map<Vertex<V>, Edge> endpoint = new HashMap<>();

}
