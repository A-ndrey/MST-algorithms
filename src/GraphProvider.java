import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graph_elements.Edge;
import graph_elements.Vertex;

public class GraphProvider {

    private static GraphProvider instance;
    private Graph<Vertex, Edge> definedGraph;

    {
        definedGraph = new UndirectedSparseGraph<>();
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
    }

    private GraphProvider(){}

    public static GraphProvider getInstance() {
        if (instance == null) instance = new GraphProvider();
        return instance;
    }

    public Graph<Vertex, Edge> getDefinedGraph() { return definedGraph;}
}
