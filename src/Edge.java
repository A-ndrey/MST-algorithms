import java.util.Objects;

public class Edge {

    private static int numberOfEdges;

    private int id;
    private int weight;
    private State state = State.VISIBLE;

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

    public void setState(State state){
        this.state = state;
    }

    public int getWeight() {
        return weight;
    }

    public State getState() {
        return state;
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

    enum State{
        VISIBLE, HIDDEN
    }
}
