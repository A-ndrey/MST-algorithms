import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class GraphProvider {

    private static GraphProvider instance;
    private Graph<Node, Edge> definedGraph;

    {
        definedGraph = new UndirectedSparseGraph<>();
        Node[] nodes = new Node[5];
        nodes[0] = new Node();
        for (int i = 0; i < nodes.length-1; i++) {
            nodes[i+1] = new Node();
            definedGraph.addEdge(new Edge(), nodes[i], nodes[i+1]);
        }
        definedGraph.addEdge(new Edge(), nodes[0], nodes[4]);
        definedGraph.addEdge(new Edge(), nodes[0], nodes[3]);
        Edge hidden = new Edge();
        hidden.setVisible(false);
        definedGraph.addEdge(hidden, nodes[2], nodes[4]);
    }

    private GraphProvider(){}

    public static GraphProvider getInstance() {
        if (instance == null) instance = new GraphProvider();
        return instance;
    }

    public Graph<Node, Edge> getDefinedGraph() { return definedGraph;}
}
