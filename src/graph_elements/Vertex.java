package graph_elements;

import advanced_data_structure.FibHeap;

import java.util.Objects;

public class Vertex {

    private static int numberOfNodes;

    private int number;
    private boolean isMarked;
    private int key;
//    private int degree;
    private Vertex parent;
    private FibHeap.Entry<Vertex> node;
//    private Vertex leftSib = this;
//    private Vertex rightSib = this;
//
//    public Vertex getLeftSib() {
//        return leftSib;
//    }
//
//    public void setLeftSib(Vertex leftSib) {
//        this.leftSib = leftSib;
//    }
//
//    public Vertex getRightSib() {
//        return rightSib;
//    }
//
//    public void setRightSib(Vertex rightSib) {
//        this.rightSib = rightSib;
//    }
//
//    public Vertex getChild() {
//        return child;
//    }
//
//    public void setChild(Vertex child) {
//        this.child = child;
//    }
//
//    private Vertex child;

    public Vertex() {
        number = ++numberOfNodes;
    }

    Vertex(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
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

//    public int getDegree() {
//        return degree;
//    }

//    public void setDegree(int degree) {
//        this.degree = degree;
//    }
}
