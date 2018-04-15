import algorithms.Algorithm;
import algorithms.PrimsAlgorithm;
import graph_elements.Edge;

import java.util.Collection;

public class TestAlgorithms {

    private Algorithm algorithm = new PrimsAlgorithm();

    public void start(){
        int pre_sum = getWeightsSum(GraphProvider.getInstance().getDefinedGraph().getEdges());
        GraphProvider.getInstance().getDefinedGraph().getEdges().forEach( e -> e.setVisible(false));
        algorithm.start(GraphProvider.getInstance().getDefinedGraph());
        int post_sum = getWeightsSum(GraphProvider.getInstance().getDefinedGraph().getEdges());
        System.out.printf("pre_sum=%d\npost_sum=%d", pre_sum, post_sum);
    }

    private static int getWeightsSum(Collection<Edge> edges){
        int sum = 0;
        for(Edge e: edges){
            if (e.isVisible()) sum += e.getWeight();
        }
        return sum;
    }
}
