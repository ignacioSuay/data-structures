package com.ignaciosuay.datastructure.graph.service;

import com.ignaciosuay.datastructure.graph.model.Edge;
import com.ignaciosuay.datastructure.graph.model.Graph;
import com.ignaciosuay.datastructure.graph.model.Vertex;

import java.util.*;

public class GraphService {


    public Map calculateForestDfs(Graph graph, Vertex u) {
        Map<Vertex, Edge> forest = new HashMap<>();
        Set<Vertex> known = new HashSet<>();
        dfs(graph, u, known, forest);
        return forest;
    }


    private void dfs(Graph graph, Vertex<String> u, Set<Vertex> known, Map<Vertex, Edge> forest) {
        known.add(u);
        for (Vertex<String> v : u.getEndpoint().keySet()) {
            if (!known.contains(v)) {
                Edge edge = u.getEndpoint().get(v);
                forest.put(v, edge);
                dfs(graph, v, known, forest);
            }
        }
    }

    public void bfs(Graph<String, String> graph, Vertex<String> start){
        List<Vertex<String>> level = new ArrayList<>();
        Set<Vertex> known = new HashSet<>();
        Map<Vertex, Edge> forest = new HashMap<>();
        level.add(start);

        while(!level.isEmpty()){
            List<Vertex<String>> newLevel = new ArrayList<>();
            for (Vertex<String> vertex : level) {
                for (Vertex<String> outVertex : vertex.getEndpoint().keySet()) {
                    if(!known.contains(outVertex)){
                        known.add(outVertex);
                        newLevel.add(outVertex);
                        forest.put(vertex, vertex.getEndpoint().get(outVertex));
                    }
                }
                level = newLevel;
            }
        }



    }

}
