import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        BST tree = new BST();
        CHashTable<String, Product> table = new CHashTable<>();
        ReadCSV.loadItems(ReadCSV.parseFile("product.csv"), tree, table);

        while(true) {
            System.out.println("Enter choice: \n[1] Quit \n[2] Add new product \n[3] Look up product \n[4] Display products \n[5] Print list by tags\n[6] Delete product\n[7] Search by price");
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

                if(productID.isEmpty() || name.isEmpty() || price < 0 || catagory.isEmpty() || quantity < 0 || tags.isEmpty()) {
                    System.out.println("Empty or invalid entry");
                    continue;
                }
                Product newProd = new Product(productID, name, price, catagory, quantity, tags);
                Node added = tree.addNode(new Node(newProd));
                
                if(added != null) {
                    System.out.println("Node added successfully");
                    table.put(newProd.getProductID(), newProd);
                }
                else {
                    System.out.println("Failed to add");
                }
            }
            else if(choice == 3) {
                System.out.println("Enter product ID to search for: ");
                String input = scnr.nextLine();
                Product search = table.get(input);
                if(search != null) {
                    System.out.println("Product found");
                    System.out.println(search);
                }
                else {
                    System.out.println("Product not found");
                }
            }
            else if(choice == 4) {
                tree.inOrder(tree.getRoot());
            }
            else if(choice == 5) {
                System.out.println("Enter the name of a tag to search for: ");
                String user = scnr.nextLine();
                HashSet<Product> set = new HashSet<>();
                set = ReadCSV.createSet(table, set, user);
                System.out.println(set.toString());
            }
            else if(choice == 6) {
                System.out.println("Enter the product ID of the item to delete: ");
                String input = scnr.nextLine();
                Product search = table.get(input);
                if(search == null) {
                    System.out.println("No product found");
                    continue;
                }
                tree.delete(search.getPrice());
                table.remove(input);
            }
            else if(choice == 7) {
                System.out.println("Enter option: \n[1] Get range of price\n[2] Get highest/lowest price");
                int priceInp = scnr.nextInt();
                scnr.nextLine();
                if(priceInp == 1) {
                    System.out.println("Enter lower bound");
                    float lower = scnr.nextFloat();
                    System.out.println("Enter upper bound");
                    float upper = scnr.nextFloat();
                    scnr.nextLine();
                    if(lower < 0 || upper <= 0) {
                        System.out.println("Invalid bounds");
                        continue;
                    }
                    tree.printRange(tree.getRoot(), lower, upper);
                }
                else if(priceInp == 2) {
                    System.out.println("Highest: " + tree.findMax());
                    System.out.println("Lowest: " + tree.findMin());
                }
                else {
                    System.out.println("Invalid option");
                }
            }

        }       
    }
}