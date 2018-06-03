import algorithms.Algorithm;
import edu.uci.ics.jung.graph.Graph;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TestAlgorithms {

    private final int LOOP_COUNT = 10;
    private Algorithm algorithm;

    public TestAlgorithms(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public void start(int numberOfVertex, boolean isStronglyConnected){
        long times[] = new long[LOOP_COUNT];
        for(int i = 0; i < LOOP_COUNT; ++i){
            System.out.print(i+1);
            Graph<Vertex, Edge> graph = GraphProvider.getInstance()
                    .getRandomCreated(numberOfVertex, isStronglyConnected);
            long start = System.nanoTime();
            algorithm.start(graph);
            times[i] = System.nanoTime() - start;
            System.out.print('\r');
        }
//        int allEdgesWeightsSum = getAllEdgesWeightsSum(graph.getEdges());
//        int visibleEdgesWeightsSum = getVisibleEdgesWeightsSum(graph.getEdges());
//        System.out.printf("%s\nTotal weights for all edges: %d\nTotal weights for edges in tree: %d\nTime: %d\n\n",
//                algorithm.getClass().getSimpleName(), allEdgesWeightsSum, visibleEdgesWeightsSum, end-start);
        System.out.printf("%s\nCount of vertices: %d\nTime (in Nano): %d\n\n" ,
                algorithm.getClass().getSimpleName(), numberOfVertex, Arrays.stream(times).sum() / LOOP_COUNT / 10);
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
