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

    public static void loadItems(ArrayList<String> lines, BST tree) {
        boolean first = true;
        for(String line : lines) {
            if(first) {
                first = false;
                continue;
            }
            String[] data = line.split(",");
            tree.addNode(new Node(new Product(data[0], data[1], Float.parseFloat(data[2]), data[3], Integer.parseInt(data[4]), data[5])));
        }
    }

    public static HashSet<Product> createSet(ArrayList<String> lines, HashSet<Product> set, String tag) {
        boolean first = true;
        for(String line : lines) {
            if(first) {
                first = false;
                continue;
            }
            String[] data = line.split(",");
            Product temp = new Product(data[0], data[1], Float.parseFloat(data[2]), data[3], Integer.parseInt(data[4]), data[5]);
            if(temp.contains(tag)) {
                set.add(temp);
            }
        }
        return set;
    }
}
