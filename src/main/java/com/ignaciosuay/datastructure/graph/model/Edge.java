package com.ignaciosuay.datastructure.graph.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Edge<E> {
    private E element;
    private Vertex start;
    private Vertex end;
    private double weight;
}
