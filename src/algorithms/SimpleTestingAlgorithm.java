package algorithms;

import edu.uci.ics.jung.graph.Graph;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.PriorityQueue;
import java.util.Random;

public class SimpleTestingAlgorithm implements Algorithm {
    @Override
    public void start(Graph<Vertex, Edge> graph) {
        Random random = new Random(42);
        graph.getEdges().forEach(edge -> {
            if (random.nextBoolean()) {
                edge.setVisible(false);
            } else {
                edge.setVisible(true);
            }
        });
    }
}
