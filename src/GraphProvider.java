import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graph_elements.Edge;
import graph_elements.Vertex;
import reading_verilog.VerilogReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraphProvider {

    private static GraphProvider instance;
    private static final int SEED = new Random().nextInt();
    private int MIN_WEIGHT = 1;
    private int MAX_WEIGHT = 20;

    public Graph<Vertex, Edge> getDefinedGraph() {
        Graph<Vertex, Edge> definedGraph = new UndirectedSparseGraph<>();
        Vertex.clear();
        Vertex[] vertices = new Vertex[9];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex();
        }
        definedGraph.addEdge(new Edge(4), vertices[0], vertices[1]);
        definedGraph.addEdge(new Edge(8), vertices[0], vertices[7]);
        definedGraph.addEdge(new Edge(8), vertices[1], vertices[2]);
        definedGraph.addEdge(new Edge(11), vertices[1], vertices[7]);
        definedGraph.addEdge(new Edge(7), vertices[2], vertices[3]);
        definedGraph.addEdge(new Edge(4), vertices[2], vertices[5]);
        definedGraph.addEdge(new Edge(2), vertices[2], vertices[8]);
        definedGraph.addEdge(new Edge(9), vertices[3], vertices[4]);
        definedGraph.addEdge(new Edge(14), vertices[3], vertices[5]);
        definedGraph.addEdge(new Edge(10), vertices[4], vertices[5]);
        definedGraph.addEdge(new Edge(2), vertices[5], vertices[6]);
        definedGraph.addEdge(new Edge(1), vertices[6], vertices[7]);
        definedGraph.addEdge(new Edge(6), vertices[6], vertices[8]);
        definedGraph.addEdge(new Edge(7), vertices[7], vertices[8]);

        return definedGraph;
    }

    public Graph<Vertex, Edge> getGraphFromVerilogFile(String fileName) throws FileNotFoundException {
        Vertex.clear();

        Map<String, Vertex> vertecies = new HashMap<>();

        Random random = new Random(SEED);

        Graph<Vertex, Edge> graph = new UndirectedSparseGraph<>();

        VerilogReader reader = VerilogReader.getInstance(new File(fileName));
        Map<String, List<String>> connections = reader.getConnections();
        Set<String> nodes = reader.getNodes();
        reader.close();

        nodes.forEach(node -> vertecies.put(node, new Vertex(node)));

        for (String key: connections.keySet()){
            List<String> localNodes = connections.get(key);
            // E2E
//            for (int i = 0; i < localNodes.size() - 1; i++){
//                for (int j = i+1; j < localNodes.size(); j++){
//                    graph.addEdge(new Edge(random.nextInt(MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT),
//                                    vertecies.get(localNodes.get(i)), vertecies.get(localNodes.get(j)));
//                }
//            }
            // F2E
            for (int i = 1; i < localNodes.size(); i++){
                graph.addEdge(new Edge(random.nextInt(MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT),
                        vertecies.get(localNodes.get(0)), vertecies.get(localNodes.get(i)));
            }

        }

        return graph;
    }

    public Graph<Vertex, Edge> getRandomCreated(int numberOfVertex, boolean isStronglyConnected) {

        Vertex.clear();

        Random random = new Random(SEED);

        Graph<Vertex, Edge> graph = new UndirectedSparseGraph<>();

        Vertex[] vertices = new Vertex[numberOfVertex];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex();
        }

        if(isStronglyConnected) {
            for (int i = 1; i < numberOfVertex; ++i) {
                while (true) {
                    graph.addEdge(new Edge(random.nextInt(MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT),
                            vertices[random.nextInt(i)], vertices[i]);
                    if (random.nextInt(5) < 2) break;
                }
            }
        } else {
            for (int i = 1; i < numberOfVertex; ++i) {
                Vertex v1 = vertices[random.nextInt(i)];
                Vertex v2 = vertices[i];
                graph.addEdge(new Edge(random.nextInt(MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT), v1, v2);
                Vertex tempV = vertices[random.nextInt(i)];
                if (random.nextInt(5) < 3)
                    graph.addEdge(new Edge(random.nextInt(MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT), v2, tempV);

            }
        }


        return graph;
    }

    private GraphProvider(){}

    public static GraphProvider getInstance() {
        if (instance == null) instance = new GraphProvider();
        return instance;
    }
}
