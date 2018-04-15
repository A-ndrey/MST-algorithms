import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graph_elements.Edge;
import graph_elements.Vertex;

public class GraphProvider {

    private static GraphProvider instance;
    private Graph<Vertex, Edge> definedGraph;

    {
        definedGraph = new UndirectedSparseGraph<>();
        Vertex[] vertices = new Vertex[5];
        vertices[0] = new Vertex();
        for (int i = 0; i < vertices.length-1; i++) {
            vertices[i+1] = new Vertex();
            definedGraph.addEdge(new Edge(), vertices[i], vertices[i+1]);
        }
        definedGraph.addEdge(new Edge(), vertices[0], vertices[4]);
        definedGraph.addEdge(new Edge(), vertices[0], vertices[3]);
        Edge hidden = new Edge();
        hidden.setVisible(false);
        definedGraph.addEdge(hidden, vertices[2], vertices[4]);
    }

    private GraphProvider(){}

    public static GraphProvider getInstance() {
        if (instance == null) instance = new GraphProvider();
        return instance;
    }

    public Graph<Vertex, Edge> getDefinedGraph() { return definedGraph;}
}
