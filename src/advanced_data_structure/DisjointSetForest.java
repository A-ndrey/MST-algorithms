package advanced_data_structure;

public class DisjointSetForest {

    public static void makeSet(Vertex vertex) {
        vertex.setKey(0);
        vertex.setParent(vertex);
    }

    public static void union(Vertex vertex1, Vertex vertex2) {
        link(findSet(vertex1), findSet(vertex2));
    }

    private static void link(Vertex vertex1, Vertex vertex2) {
        if (vertex1.getKey() > vertex2.getKey()) {
            vertex2.setParent(vertex1);
        } else {
            vertex1.setParent(vertex2);
            if (vertex1.getKey() == vertex2.getKey()) {
                vertex2.setKey(vertex2.getKey() + 1);
            }
        }
    }

    public static Vertex findSet(Vertex vertex) {
        if (vertex != vertex.getParent()){
            vertex.setParent(findSet(vertex.getParent()));
        }
        return vertex.getParent();
    }

    public static class Vertex {

        private int key;

        private Vertex parent;

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
    }

}
