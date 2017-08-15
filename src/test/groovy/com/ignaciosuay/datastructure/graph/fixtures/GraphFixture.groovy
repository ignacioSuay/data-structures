package com.ignaciosuay.datastructure.graph.fixtures

import com.ignaciosuay.datastructure.graph.model.Graph

import static com.ignaciosuay.datastructure.graph.fixtures.VertexFixtures.aVertex

class GraphFixture {

//            d
//          /
//    a -> b -> c-> e
//
    def static Graph aGraph(){
        Graph<String, String> graph = new Graph<>()
        def vertexA = aVertex("a")
        def vertexB = aVertex("b")
        def vertexC = aVertex("c")
        def vertexD = aVertex("d")
        def vertexE = aVertex("e")
        graph.addListVertex([vertexA, vertexB, vertexC, vertexD,vertexE])

        graph.insertEdge(vertexA, vertexB, "a-b")
        graph.insertEdge(vertexB, vertexC, "b-c")
        graph.insertEdge(vertexB, vertexD, "b-d")
        graph.insertEdge(vertexC, vertexE, "c-e")

        graph
    }

}
