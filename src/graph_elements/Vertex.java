package graph_elements;

import advanced_data_structure.FibHeap;

import java.util.Objects;

public class Vertex {

    private static int numberOfNodes;

    private String name;
    private boolean isMarked;
    private int key;
    private Vertex parent;
    private FibHeap.Entry<Vertex> node;


    public Vertex() {
        name = String.valueOf(++numberOfNodes);
    }

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void clear() {
        numberOfNodes = 0;
    }

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
        return name.equals(vertex.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name=" + name +
                ", key=" + getKey() + '}';
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public FibHeap.Entry<Vertex> getNode() {
        return node;
    }

    public void setNode(FibHeap.Entry<Vertex> node) {
        this.node = node;
    }
}
