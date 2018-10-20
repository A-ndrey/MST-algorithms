package algorithms;

import advanced_data_structure.FibHeap;
import edu.uci.ics.jung.graph.Graph;
import graph_elements.Edge;
import graph_elements.Vertex;

public class PrimsAlgorithm implements Algorithm {

    @Override
    public void start(Graph<Vertex, Edge> graph) {
        FibHeap<Vertex> vertexPriorityQueue = new FibHeap<>();
        graph.getVertices().forEach( v -> {
            v.setKey(Integer.MAX_VALUE);
            v.setMarked(false);
            v.setParent(null);
            v.setNode(vertexPriorityQueue.enqueue(v, v.getKey()));
        });
        Vertex vert = vertexPriorityQueue.min().getValue();
        vert.setKey(0);
        vertexPriorityQueue.decreaseKey(vert.getNode() , vert.getKey());

        while (!vertexPriorityQueue.isEmpty()) {
            Vertex u = vertexPriorityQueue.dequeueMin().getValue();
            u.setMarked(true);
            markEdge(u, graph);
            graph.getNeighbors(u).forEach(v -> {
                if (!v.isMarked()) {
                    Edge edge = graph.findEdge(u,v);
                    if (edge.getWeight() < v.getKey()){
                        v.setParent(u);
                        v.setKey(edge.getWeight());
                        vertexPriorityQueue.decreaseKey(v.getNode(), v.getKey());
                    }
                }
            });
        }
    }

    private void markEdge(Vertex vertex, Graph<Vertex, Edge> graph) {
        if (vertex.getParent() == null) return;
        graph.findEdge(vertex, vertex.getParent()).setVisible(true);
    }
}
