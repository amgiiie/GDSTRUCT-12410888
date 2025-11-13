public class Tree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        }
        else {
            root.insert(value);
        }
    }

    public void inOrderTraverse() {
        if (root != null) {
            root.inOrderTraverse();
        }
    }
    public void traverseInOrderDescending() {
        if (root != null) {
            root.traverseInOrderDescending();
        }
    }

    public Node get(int value) {
        if (root == null) {
            return  null;
        }

        return  root.get(value);
    }

    public Node getMin() {
        if (root == null) {
            return  null;
        }

        return  root.getMin();
    }

    public Node getMax() {
        if (root == null) {
            return  null;
        }

        return  root.getMax();
    }
}