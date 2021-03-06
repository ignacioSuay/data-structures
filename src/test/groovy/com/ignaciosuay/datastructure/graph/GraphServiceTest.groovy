package com.ignaciosuay.datastructure.graph

import com.ignaciosuay.datastructure.graph.service.GraphService
import spock.lang.Specification

import static com.ignaciosuay.datastructure.graph.fixtures.GraphFixture.aGraph
import static com.ignaciosuay.datastructure.graph.fixtures.GraphFixture.weightedGraph

class GraphServiceTest extends Specification {

    GraphService graphService = new GraphService()

    def "Calculate forest graph using dfs"() {

        given:
        def graph = aGraph()

        when:
        def result = graphService.calculateForestDfs(aGraph(), graph.getVertices()[0])

        then:
        result
        result.size() == 4
        result.keySet().collect { it.getElement() } == ["b", "c", "e", "d"]
    }

    def "Calculate forest graph using bfs"() {

        given:
        def graph = aGraph()

        when:
        def result = graphService.bfs(aGraph(), graph.getVertices()[0])

        then:
        result
        result.size() == 4
        result.keySet().collect { it.getElement() } == ["b", "c", "d", "e"]
    }

    def "Calculate dijkstrar algofirthm"(){

        given:
        def graph = weightedGraph()

        when:
        def result = graphService.dijkstra(graph, graph.vertices[0])

        then:
        result
        result[graph.vertices[0]] == 0
        result[graph.vertices[1]] == 10
        result[graph.vertices[2]] == 30
    }
}
