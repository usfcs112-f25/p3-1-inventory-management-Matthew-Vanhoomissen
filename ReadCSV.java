import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class ReadCSV {
    public static ArrayList<String> parseFile(String fileName) {
        BufferedReader reader = null;
        String line = null;
        ArrayList<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            while((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if(reader != null) {
                try {
                    reader.close();
                }
                catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return lines;
    }

    public static void loadItems(ArrayList<String> lines, BST tree, CHashTable<String, Product> table) {
        boolean first = true;
        for(String line : lines) {
            if(first) {
                first = false;
                continue;
            }
            String[] data = line.split(",");
            Product temp = new Product(data[0], data[1], Float.parseFloat(data[2]), data[3], Integer.parseInt(data[4]), data[5]);
            table.put(data[0], temp);
            tree.addNode(new Node(new Product(data[0], data[1], Float.parseFloat(data[2]), data[3], Integer.parseInt(data[4]), data[5])));
        }
    }

    public static HashSet<Product> createSet(CHashTable<String, Product> table, HashSet<Product> set, String tag) {
        for(int i = 0; i < table.getSize(); i++) {
            if(table.getEntry(i) != null && table.getValue(i) != null && table.getValue(i).contains(tag)) {
                set.add(table.getValue(i));
            }
        }
        
        return set;
    }
}
