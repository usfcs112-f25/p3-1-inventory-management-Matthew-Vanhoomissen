import java.util.ArrayList;
/** Binary Search Tree
* Stores Nodes in order
* Author: Matthew
* Version: 12/1/25
 */
public class BST {
    //Stores the first value as root and the size
    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    /*
    @returns the root */
    public Node getRoot() {
        return root;
    }

    /**
    * adds a node to the tree
    @returns the added node or null if a duplicate
    @params node to add */
    public Node addNode(Node node) {
        if(root == null) {
            root = node;
            this.size++;
            return node;
        }

        Node traser = root;
        while(true) {
            //If the node to add has a greater price than the curr node, go to the right
            //unless the right is null 
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
            //If node to add has less price than the curr node, go to the left
            //unless the left is null
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
                //If equal return null bc you can't have same values
                return null;
            }
        }
    }
    /**
     * Prints out the nodes in order
     * @params the node to start from */
    public void inOrder(Node node) {
        if (node == null)
            return;
        
        inOrder(node.getLeft());
        
        System.out.println(node);        

        inOrder(node.getRight());
    }

    /**
     * Deletes a value from the BST.
     * @params the price to delete from the tree
     */
    public void delete(float value) {
        root = deleteHelper(root, value);
    }

    /**
     * Helper method for delete - recursively finds and removes the node
     * @params the node you enter through and the price to delete
     * @return the node thats deleted
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
            // Case 2 - Node has one child (left or right)
            // Return the non-null child to replace this node
        
            Product smallest = findMin(node.getRight());
            node.setData(smallest);
            node.setRight(deleteHelper(node.getRight(), smallest.getPrice()));
       
            // Case 3 - Node has two children
            // Find the inorder successor (smallest value in right subtree)
            // Replace node's value with successor's value
            // Delete the successor node from the right subtree
        
            
        }
        return node;
    }

    /**
     * 
     * @param node to start at
     * @return the data from the min
     */
    private Product findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    /**
     * 
     * @return min
     */
    public Product findMin() {
        Node temp = root;
        while(temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp.getData();
    }

    /**
     * 
     * @return max
     */
    public Product findMax() {
        Node temp = root;
        while(temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getData();
    }

    /**
     * Prints nodes in the given range
     * Follows similar logic to inorder traversal
     * @param node
     * @param low
     * @param high
     */
    public void printRange(Node node, float low, float high) {
        if (node == null) return;

        float price = node.getData().getPrice();
        //Explores the left branch
        if (node.getData().getPrice() > low) {
            printRange(node.getLeft(), low, high);
        }

        //Prints the current node
        if (price >= low && price <= high) {
            System.out.print(node.getData());
        }

        //Explores the right branch
        if (price < high) {
            printRange(node.getRight(), low, high);
        }
    }

    
}
