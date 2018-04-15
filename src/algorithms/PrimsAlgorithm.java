package algorithms;

import com.sun.istack.internal.Nullable;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Pair;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.*;

public class PrimsAlgorithm implements Algorithm {

    @Override
    public void start(Graph<Vertex, Edge> graph) {
        PriorityQueue<Vertex> vertexPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(Vertex::getKey));
        vertexPriorityQueue.addAll(graph.getVertices());
        vertexPriorityQueue.peek().setKey(0);

        while (!vertexPriorityQueue.isEmpty()) {
            Vertex u = vertexPriorityQueue.poll();
            markEdge(u, graph);
            getNeighborsTree(u, graph).forEach(v -> {
                if (vertexPriorityQueue.contains(v)) {
                    Edge edge = findEdge(u, v, graph);
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

    private Set<Vertex> getNeighborsTree(Vertex source, Graph<Vertex, Edge> graph) {
        Set<Vertex> set = new HashSet<>(graph.getNeighbors(source));
        if (source.getParent() != null) {
            set.addAll(getNeighborsTree(source.getParent(), graph));
            set.remove(source);
        }
        return set;
    }

    private Edge findEdge(Vertex u, Vertex v, Graph<Vertex, Edge> graph) {
        Edge parentEdge = u.getParent() == null ? null : findEdge(u.getParent(), v, graph);
        Edge edge = graph.findEdge(u, v);
        if (parentEdge == null) return edge;
        if (edge == null) return parentEdge;
        return edge.getWeight() <= parentEdge.getWeight()? edge : parentEdge;
    }

    private void markEdge(Vertex vertex, Graph<Vertex, Edge> graph) {
        if (vertex.getParent() == null) return;
        graph.findEdge(vertex, vertex.getParent()).setVisible(true);
    }
}
