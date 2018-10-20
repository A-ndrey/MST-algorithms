import algorithms.Algorithm;
import edu.uci.ics.jung.graph.Graph;
import graph_elements.Edge;
import graph_elements.Vertex;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class TestVerilogAlgorithms extends TestAlgorithms {

    private final String[] files = {"c17.v", "c432.v", "c499.v", "c880a.v", "c1908.v", "c2670.v", "c3540.v", "c5315.v", "c6288.v", "c7552.v"};


    public TestVerilogAlgorithms(Algorithm algorithm) {
        super(algorithm);
        LOOP_COUNT = 10_000;
    }

    public void start() throws FileNotFoundException {
        System.out.println(algorithm.getClass().getSimpleName());

        for (String file : files) {
            long times[] = new long[LOOP_COUNT];
            Graph<Vertex, Edge> graph;
            for (int i = 0; i < LOOP_COUNT; ++i) {
                graph = GraphProvider.getInstance()
                        .getGraphFromVerilogFile("resources/" + file);
                long start = System.nanoTime();
                algorithm.start(graph);
                times[i] = System.nanoTime() - start;
            }
            System.out.println(Arrays.stream(times).sum() / LOOP_COUNT);
        }
    }
}
