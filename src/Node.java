import java.util.Objects;

public class Node {

    private static int numberOfNodes;

    private int number;

    Node(){
        number = ++numberOfNodes;
    }

    Node(int number){
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return number == node.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                '}';
    }
}
