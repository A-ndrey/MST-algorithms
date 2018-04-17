package algorithms;

import advanced_data_structure.DisjointSetForest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.Pair;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.Comparator;

public class KruskalsAlgorithm implements Algorithm {

    @Override
    public void start(Graph<Vertex, Edge> graph) {
        graph.getVertices().forEach(DisjointSetForest::makeSet);
        graph.getEdges().stream().sorted(Comparator.comparingInt(Edge::getWeight))
                .forEach( edge -> {
                    Pair<Vertex> pair = graph.getEndpoints(edge);
                    if (DisjointSetForest.findSet(pair.getFirst()) != DisjointSetForest.findSet(pair.getSecond())){
                        edge.setVisible(true);
                        DisjointSetForest.union(pair.getFirst(), pair.getSecond());
                    }
                });
    }

}
