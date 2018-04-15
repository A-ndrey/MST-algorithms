package algorithms;

import edu.uci.ics.jung.graph.Graph;
import graph_elements.Edge;
import graph_elements.Vertex;

public interface Algorithm {

    void start(Graph<Vertex, Edge> graph);
}
