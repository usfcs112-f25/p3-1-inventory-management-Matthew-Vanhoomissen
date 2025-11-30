public class Node {
    private Node left;
    private Node right;
    private Product data;

    public Node(Product data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public Product getData() {
        return data;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public String toString() {
        return data.toString();
    }
}
