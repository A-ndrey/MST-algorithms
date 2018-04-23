package algorithms;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Pair;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimsAlgorithm implements Algorithm {

    @Override
    public void start(Graph<Vertex, Edge> graph) {
        PriorityQueue<Vertex> vertexPriorityQueue = new PriorityQueue<>(graph.getVertexCount(), Comparator.comparingInt(Vertex::getKey));
        graph.getVertices().forEach( v -> {
            v.setKey(Integer.MAX_VALUE);
            v.setParent(null);
            vertexPriorityQueue.add(v);
        });
        vertexPriorityQueue.peek().setKey(0);

        while (!vertexPriorityQueue.isEmpty()) {
            Vertex u = vertexPriorityQueue.poll();
            markEdge(u, graph);
            graph.getNeighbors(u).forEach(v -> {
                if (vertexPriorityQueue.contains(v)) {
                    Edge edge = graph.findEdge(u,v);
                    Pair<Vertex> p = graph.getEndpoints(edge);
                    Vertex u1 = p.getFirst().equals(v) ? p.getSecond() : p.getFirst();
                    if (edge.getWeight() < v.getKey()){
                        v.setParent(u1);
                        v.setKey(edge.getWeight());
                        vertexPriorityQueue.remove(v);
                        vertexPriorityQueue.add(v);
                    }
                }
            });
        }
    }

    private void markEdge(Vertex vertex, Graph<Vertex, Edge> graph) {
        if (vertex.getParent() == null) return;
        graph.findEdge(vertex, (Vertex) vertex.getParent()).setVisible(true);
    }
}
