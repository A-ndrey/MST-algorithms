package graph_elements;

import java.util.Objects;

public class Vertex {

    private static int numberOfNodes;

    private int number;

    private int key = Integer.MAX_VALUE;

    private Vertex parent;

    public Vertex(){
        number = ++numberOfNodes;
    }

    Vertex(int number){
        this.number = number;
    }

    public int getNumber() {return number;}

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return number == vertex.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "number=" + number +
                ", key=" + key + '}';
    }
}
