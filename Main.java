import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        BST tree = new BST();

        while(true) {
            System.out.println("Enter choice: \n[1] Quit \n[2] Add new product \n[3] Look up product \n[4] Display products \n[5] Sort list");
            int choice = scnr.nextInt();
            scnr.nextLine();

            if(choice == 1) {
                System.out.println("Existing system");
                break;
            }
            else if(choice == 2) {
                System.out.println("Enter product ID: ");
                String productID = scnr.nextLine();
                System.out.println("Enter name: ");
                String name = scnr.nextLine();
                System.out.println("Enter product price: ");
                int price = scnr.nextInt();
                scnr.nextLine();
                System.out.println("Enter catagory: ");
                String catagory = scnr.nextLine();
                System.out.println("Enter quantity: ");
                int quantity = scnr.nextInt();
                scnr.nextLine();
                System.out.println("Enter tags(separate by semi-colons no space): ");
                String tags = scnr.nextLine();
                Node added = tree.addNode(new Node(new Product(productID, name, price, catagory, quantity, tags)));
                if(added != null) {
                    System.out.println("Node added successfully");
                }
                else {
                    System.out.println("Failed to add");
                }
            }
            else if(choice == 4) {
                tree.inOrder(tree.getRoot());
            }

        }       
    }
}