import algorithms.Algorithm;
import edu.uci.ics.jung.graph.Graph;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TestAlgorithms {

    protected int LOOP_COUNT = 1;
    protected Algorithm algorithm;

    public TestAlgorithms(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public void start(boolean isStronglyConnected) {
        System.out.println(algorithm.getClass().getSimpleName() + " with "
                + (isStronglyConnected ? "strongly" : "weakly") + " connected graph" );
        for (int countV = 1_000; countV <= 100_000; countV += 10_000) {
            long times[] = new long[LOOP_COUNT];
            Graph<Vertex, Edge> graph;
            for (int i = 0; i < LOOP_COUNT; ++i) {
                System.out.print(i + 1);
                graph = GraphProvider.getInstance()
                        .getRandomCreated(countV, isStronglyConnected);
                long start = System.nanoTime();
                algorithm.start(graph);
                times[i] = System.nanoTime() - start;
                System.out.print('\r');
            }
//            int allEdgesWeightsSum = getAllEdgesWeightsSum(graph.getEdges());
//            int visibleEdgesWeightsSum = getVisibleEdgesWeightsSum(graph.getEdges());
            System.out.println(Arrays.stream(times).sum() / LOOP_COUNT);
        }
    }

    protected static int getVisibleEdgesWeightsSum(Collection<Edge> edges){
        int sum = 0;
        for(Edge e: edges){
            if (e.isVisible()) sum += e.getWeight();
        }
        return sum;
    }

    protected static int getAllEdgesWeightsSum(Collection<Edge> edges){
        int sum = 0;
        for(Edge e: edges){
            sum += e.getWeight();
        }
        return sum;
    }
}
