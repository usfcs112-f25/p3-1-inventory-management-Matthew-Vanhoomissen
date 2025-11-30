import java.util.ArrayList;

public class BST {
    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public Node getRoot() {
        return root;
    }

    public Node addNode(Node node) {
        if(root == null) {
            root = node;
            this.size++;
            return node;
        }

        Node traser = root;
        while(true) {
            if(node.getData().getPrice() > traser.getData().getPrice()) {
                if(traser.getRight() == null) {
                    traser.setRight(node);
                    this.size++;
                    return node;
                }
                else {
                    traser = traser.getRight();
                }
            }
            else if(node.getData().getPrice() < traser.getData().getPrice()) {
                if(traser.getLeft() == null) {
                    traser.setLeft(node);
                    this.size++;
                    return node;
                }
                else {
                    traser = traser.getLeft();
                }
            }
            else {
                return null;
            }
        }
    }
    public void inOrder(Node node) {
        if (node == null)
            return;
        
        inOrder(node.getLeft());
        
        System.out.println(node);        

        inOrder(node.getRight());
    }
}
