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

    /**
     * Deletes a value from the BST.
     * TODO: Implement deletion logic
     */
    public void delete(float value) {
        root = deleteHelper(root, value);
    }

    /**
     * Helper method for delete - recursively finds and removes the node
     */
    private Node deleteHelper(Node node, float value) {
        if (node == null) {
            return null;
        }

        if (value < node.getData().getPrice()) {
            node.setLeft(deleteHelper(node.getLeft(), value)) ;
        } 
        else if (value > node.getData().getPrice()) {
            node.setRight(deleteHelper(node.getRight(), value));
        } 
        else {
            if(node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            // Case 1 - Node has no children (leaf node)
            // Return null to remove the node
        
            if(node.getLeft() == null || node.getRight() == null) {
                if(node.getLeft() == null) {
                    return node.getRight();
                }
                else {
                    return node.getLeft();
                }
            }
            // TODO: Case 2 - Node has one child (left or right)
            // Return the non-null child to replace this node
        
            Product smallest = findMin(node.getRight());
            node.setData(smallest);
            node.setRight(deleteHelper(node.getRight(), smallest.getPrice()));
       
            // TODO: Case 3 - Node has two children
            // Find the inorder successor (smallest value in right subtree)
            // Replace node's value with successor's value
            // Delete the successor node from the right subtree
        
            
        }
        return node;
    }

    private Product findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    public Product findMin() {
        Node temp = root;
        while(temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp.getData();
    }

    public Product findMax() {
        Node temp = root;
        while(temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getData();
    }

    public void printRange(Node node, float low, float high) {
        if (node == null) return;

        float price = node.getData().getPrice();
        if (node.getData().getPrice() > low) {
            printRange(node.getLeft(), low, high);
        }

        if (price >= low && price <= high) {
            System.out.print(node.getData());
        }

        if (price < high) {
            printRange(node.getRight(), low, high);
        }
    }

    
}
