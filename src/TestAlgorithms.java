import algorithms.Algorithm;
import edu.uci.ics.jung.graph.Graph;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.Collection;
import java.util.Collections;

public class TestAlgorithms {

    private Algorithm algorithm;
    private Graph<Vertex, Edge> graph;

    public TestAlgorithms(Graph<Vertex, Edge> graph, Algorithm algorithm){
        this.graph = graph;
        this.algorithm = algorithm;
    }

    public void start(){
        algorithm.start(graph);
        int allEdgesWeightsSum = getAllEdgesWeightsSum(graph.getEdges());
        int visibleEdgesWeightsSum = getVisibleEdgesWeightsSum(graph.getEdges());
        System.out.printf("%s\nallEdges=%d\ninTree=%d\n\n", algorithm.getClass().getSimpleName(), allEdgesWeightsSum, visibleEdgesWeightsSum);
    }

    private static int getVisibleEdgesWeightsSum(Collection<Edge> edges){
        int sum = 0;
        for(Edge e: edges){
            if (e.isVisible()) sum += e.getWeight();
        }
        return sum;
    }

    private static int getAllEdgesWeightsSum(Collection<Edge> edges){
        int sum = 0;
        for(Edge e: edges){
            sum += e.getWeight();
        }
        return sum;
    }
}
