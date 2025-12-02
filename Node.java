/**
 * Node class for binary search tree
 * @author Matthew
 * @version 12/1/25
 */
public class Node {
    private Node left;
    private Node right;
    private Product data;

    //Initializes node
    public Node(Product data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //Setters and getters
    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public void setData(Product data) {
        this.data = data;
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
