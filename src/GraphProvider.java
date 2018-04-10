import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class GraphProvider {

    private static Graph<Node, Edge> definedGraph;

    static {
        definedGraph = new UndirectedSparseGraph<>();
        Node[] nodes = new Node[5];
        nodes[0] = new Node();
        for (int i = 0; i < nodes.length-1; i++) {
            nodes[i+1] = new Node();
            definedGraph.addEdge(new Edge(), nodes[i], nodes[i+1]);
        }
        definedGraph.addEdge(new Edge(), nodes[0], nodes[3]);
        definedGraph.addEdge(new Edge(), nodes[2], nodes[4]);
    }

    public static Graph<Node, Edge> getDefinedGraph() { return definedGraph;}
}
