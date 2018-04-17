import algorithms.Algorithm;
import graph_elements.Edge;

import java.util.Collection;

public class TestAlgorithms {

    private Algorithm algorithm;

    public TestAlgorithms(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public void start(){
        GraphProvider.getInstance().getDefinedGraph().getEdges().forEach( e -> e.setVisible(false));
        algorithm.start(GraphProvider.getInstance().getDefinedGraph());
        int allEdgesWeightsSum = getAllEdgesWeightsSum(GraphProvider.getInstance().getDefinedGraph().getEdges());
        int visibleEdgesWeightsSum = getVisibleEdgesWeightsSum(GraphProvider.getInstance().getDefinedGraph().getEdges());
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
