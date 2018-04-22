package algorithms;

import advanced_data_structure.DisjointSetForest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.Pair;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.Comparator;

public class BoruvkasAlgorithm implements Algorithm {

    @Override
    public void start(Graph<Vertex, Edge> graph) {
        while(graph.getVertexCount() > 1){
            graph = reduce(graph);
        }
    }

    private Graph<Vertex, Edge> reduce(Graph<Vertex, Edge> graph) {
        Graph<Vertex, Edge> anotherGraph = new UndirectedSparseGraph<>();

        graph.getVertices().forEach(v -> {
            v.setMarked(false);
            DisjointSetForest.makeSet(v);
        });

        graph.getVertices().forEach(u -> {
            if (!u.isMarked()) {
                Edge minEdge = graph.getIncidentEdges(u).stream().min(Comparator.comparingInt(Edge::getWeight)).get();
                Pair<Vertex> pair = graph.getEndpoints(minEdge);
                DisjointSetForest.union(pair.getFirst(), pair.getSecond());
                minEdge.getOrigin().setVisible(true);
                pair.getFirst().setMarked(true);
                pair.getSecond().setMarked(true);
            }
        });

        graph.getEdges().forEach(edge -> {
            Pair<Vertex> pair = graph.getEndpoints(edge);
            Vertex u = (Vertex) DisjointSetForest.findSet(pair.getFirst());
            Vertex v = (Vertex) DisjointSetForest.findSet(pair.getSecond());
            if(!u.equals(v)) {
                Edge e = graph.findEdge(u, v);
                if (!anotherGraph.containsEdge(e)) {
                    if (e == null) e = new Edge();
                    anotherGraph.addEdge(e, v, u); //warning!
                    e.setOrigin(edge.getOrigin());
                    e.setWeight(edge.getWeight());
                } else if (edge.getWeight() < e.getWeight()) {
                    e.setOrigin(edge.getOrigin());
                    e.setWeight(edge.getWeight());
                }
            }
        });
        return anotherGraph;
    }
}
