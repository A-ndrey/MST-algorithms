package graph_elements;

import advanced_data_structure.DSFVertex;

import java.util.Objects;

public class Vertex extends DSFVertex {

    private static int numberOfNodes;

    private int number;

    public Vertex(){
        number = ++numberOfNodes;
    }

    Vertex(int number){
        this.number = number;
    }

    public int getNumber() {return number;}


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
}
