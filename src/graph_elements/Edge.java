package graph_elements;

import java.util.Objects;

public class Edge {

    private static int numberOfEdges;

    private int id;
    private int weight;
    private boolean isVisible = true;

    public Edge(){
        this(1);
    }

    public Edge(int weight){
        this(++numberOfEdges, weight);
    }

    Edge(int id, int weight){
        this.id = id;
        this.weight = weight;
    }

    public void setVisible(boolean visible){
        this.isVisible = visible;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return id == edge.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "graph_elements.Edge{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
