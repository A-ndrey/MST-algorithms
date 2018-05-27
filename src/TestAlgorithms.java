import algorithms.Algorithm;
import edu.uci.ics.jung.graph.Graph;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.Collection;
import java.util.Collections;

public class TestAlgorithms {

    private Algorithm algorithm;

    public TestAlgorithms(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public void start(Graph<Vertex, Edge> graph){
        long start = System.nanoTime();
        algorithm.start(graph);
        long end = System.nanoTime();
//        int allEdgesWeightsSum = getAllEdgesWeightsSum(graph.getEdges());
//        int visibleEdgesWeightsSum = getVisibleEdgesWeightsSum(graph.getEdges());
//        System.out.printf("%s\nTotal weights for all edges: %d\nTotal weights for edges in tree: %d\nTime: %d\n\n",
//                algorithm.getClass().getSimpleName(), allEdgesWeightsSum, visibleEdgesWeightsSum, end-start);
        System.out.printf("%s\nCount of vertices: %d\nTime (in Nano): %d\n\n" , algorithm.getClass().getSimpleName(), graph.getVertexCount(), end-start);
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
