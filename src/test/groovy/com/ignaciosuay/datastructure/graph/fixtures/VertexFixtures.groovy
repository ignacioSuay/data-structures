package com.ignaciosuay.datastructure.graph.fixtures

import com.ignaciosuay.datastructure.graph.model.Vertex

class VertexFixtures {

    def static Vertex aVertex(String value){
        Vertex<String> v = new Vertex<>(element: value)
    }
}
