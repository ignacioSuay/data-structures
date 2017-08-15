package com.ignaciosuay.datastructure.graph.service;

import com.ignaciosuay.datastructure.graph.model.Edge;
import com.ignaciosuay.datastructure.graph.model.Graph;
import com.ignaciosuay.datastructure.graph.model.Vertex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphService {


    public Map calculateForestDfs(Graph graph, Vertex u) {
        Map<Vertex, Edge> forest = new HashMap<>();
        Set<Vertex> known = new HashSet<>();
        dfs(graph, u, known, forest);
        return forest;
    }


    private void dfs(Graph graph, Vertex u, Set<Vertex> known, Map<Vertex, Edge> forest) {
        known.add(u);
        for (Object v : u.getEndpoint().keySet()){
            Vertex vVertex = (Vertex) v;
            if(!known.contains(vVertex)){
                Edge edge = (Edge) u.getEndpoint().get(vVertex);
                forest.put(vVertex, edge);
                dfs(graph, vVertex, known, forest);
            }
        }


    }

}
