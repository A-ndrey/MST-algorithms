import java.util.Objects;

public class Edge {

    private static int numberOfEdges;

    private int id;
    private int weight;

    Edge(){
        this(1);
    }

    Edge(int weight){
        this(++numberOfEdges, weight);
    }

    Edge(int id, int weight){
        this.id = id;
        this.weight = weight;
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
        return "Edge{" +
                "id=" + id +
                ", weight=" + weight +
                '}';
    }
}
