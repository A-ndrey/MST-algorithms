package advanced_data_structure;

public class DisjointSetForest {

    private static DisjointSetForest instance;

    private DisjointSetForest() {
    }

    public static DisjointSetForest getInstance() {
        if (instance == null) instance = new DisjointSetForest();
        return instance;
    }

    public void makeSet(DSFVertex vertex) {
        vertex.setKey(0);
        vertex.setParent(vertex);
    }

    public void union(DSFVertex vertex1, DSFVertex vertex2) {
        link(findSet(vertex1), findSet(vertex2));
    }

    private void link(DSFVertex vertex1, DSFVertex vertex2) {
        if (vertex1.getKey() > vertex2.getKey()) {
            vertex2.setParent(vertex1);
        } else {
            vertex1.setParent(vertex2);
            if (vertex1.getKey() == vertex2.getKey()) {
                vertex2.setKey(vertex2.getKey() + 1);
            }
        }
    }

    public DSFVertex findSet(DSFVertex vertex) {
        if (vertex != vertex.getParent()){
            vertex.setParent(findSet(vertex.getParent()));
        }
        return vertex.getParent();
    }

}
