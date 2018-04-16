package advanced_data_structure;

public class DSFVertex {

    private int key;

    private DSFVertex parent;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public DSFVertex getParent() {
        return parent;
    }

    public void setParent(DSFVertex parent) {
        this.parent = parent;
    }
}
