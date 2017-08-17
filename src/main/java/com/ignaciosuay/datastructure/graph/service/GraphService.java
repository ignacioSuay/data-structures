package com.ignaciosuay.datastructure.graph.service;

import com.ignaciosuay.datastructure.graph.model.Edge;
import com.ignaciosuay.datastructure.graph.model.Graph;
import com.ignaciosuay.datastructure.graph.model.Vertex;

import java.util.*;

public class GraphService {


    public Map<Vertex, Edge> calculateForestDfs(Graph graph, Vertex u) {
        Map<Vertex, Edge> forest = new LinkedHashMap<>();
        Set<Vertex> known = new HashSet<>();
        dfs(graph, u, known, forest);
        return forest;
    }


    private <V, E> void dfs(Graph graph, Vertex<V, E> u, Set<Vertex> known, Map<Vertex, Edge> forest) {
        known.add(u);
        for (Vertex<V, E> v : u.getEndpoint().keySet()) {
            if (!known.contains(v)) {
                Edge edge = u.getEndpoint().get(v);
                forest.put(v, edge);
                dfs(graph, v, known, forest);
            }
        }
    }

    public <V, E> Map<Vertex<V, E>, Edge<E>> bfs(Graph<V, E> graph, Vertex<V, E> start) {
        List<Vertex<V, E>> level = new ArrayList<>();
        Set<Vertex> known = new HashSet<>();
        Map<Vertex<V, E>, Edge<E>> forest = new LinkedHashMap<>();
        level.add(start);
        known.add(start);

        while (!level.isEmpty()) {
            List<Vertex<V, E>> newLevel = new ArrayList<>();
            for (Vertex<V, E> vertex : level) {
                for (Vertex<V, E> outVertex : vertex.getEndpoint().keySet()) {
                    if (!known.contains(outVertex)) {
                        known.add(outVertex);
                        newLevel.add(outVertex);
                        forest.put(outVertex, vertex.getEndpoint().get(outVertex));
                    }
                }
                level = newLevel;
            }
        }
        return forest;
    }

    public <V, E> Map<Vertex, Integer> dijkstra(Graph<V, E> graph, Vertex<V, E> start) {
        Map<Vertex, Integer> distance = new HashMap<>();
        Set<Vertex> known = new HashSet<>();
        Map<Vertex<V, E>, Integer> unsettledNodes = new HashMap<>();

        initializeDistance(graph, start, distance);
        unsettledNodes.put(start, 0);

        while (!unsettledNodes.isEmpty()) {
            Map.Entry<Vertex<V, E>, Integer> node = getMinDistance(unsettledNodes);
            unsettledNodes.remove(node.getKey());
            for (Map.Entry<Vertex<V, E>, Edge<E>> vertexEdgeEntry : node.getKey().getEndpoint().entrySet()) {

                if (!known.contains(vertexEdgeEntry.getKey())) {

                    double dist = vertexEdgeEntry.getValue().getWeight() + distance.get(node.getKey());

                    if (dist < distance.get(vertexEdgeEntry.getKey())) {
                        distance.put(vertexEdgeEntry.getKey(), (int) dist);
                        unsettledNodes.put(vertexEdgeEntry.getKey(), (int) dist);
                    }
                }

            }
            known.add(node.getKey());
        }
        return distance;

    }

    private <V, E> void initializeDistance(Graph<V, E> graph, Vertex<V, E> start, Map<Vertex, Integer> distance) {
        for (Vertex<V, E> gVertex : graph.getVertices()) {
            if (gVertex.equals(start))
                distance.put(gVertex, 0);
            else
                distance.put(gVertex, Integer.MAX_VALUE);
        }
    }

    private <V, E> Map.Entry<Vertex<V, E>, Integer> getMinDistance(Map<Vertex<V, E>, Integer> unsettledNodes) {
        return unsettledNodes.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).get();
    }

}
