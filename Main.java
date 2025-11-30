import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        BST tree = new BST();
        HashSet<Product> set1 = new HashSet<>();
        HashSet<Product> set2 = new HashSet<>();
        set1 = ReadCSV.createSet(ReadCSV.parseFile("product.csv"), set1, "electronics");
        set2 = ReadCSV.createSet(ReadCSV.parseFile("product.csv"), set2, "clothing");
        ReadCSV.loadItems(ReadCSV.parseFile("product.csv"), tree);

        while(true) {
            System.out.println("Enter choice: \n[1] Quit \n[2] Add new product \n[3] Look up product \n[4] Display products \n[5] Print list by tags");
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
            else if(choice == 5) {
                System.out.println("Select which list to display: \n[1] Electronics\n[2] Clothing");
                int user = scnr.nextInt();
                scnr.nextLine();
                if(user == 1) {
                    System.out.println(set1.toString());
                }
                else if(user == 2) {
                    System.out.println(set2.toString());
                }
            }

        }       
    }
}