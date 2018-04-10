import edu.uci.ics.jung.graph.Graph;

import java.util.Random;

public class SimpleTestingAlgorithm implements Algorithm {
    @Override
    public void start(Graph<Node, Edge> graph) {
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
