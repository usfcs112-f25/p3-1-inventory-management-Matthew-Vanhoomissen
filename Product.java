public class Product {
    private String productID;
    private String name;
    private float price;
    private String category;
    private int quanitity;
    private String[] tags;

    public Product(String productID, String name, float price, String category, int quantity, String tagList) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quanitity = quantity;
        this.tags = tagList.split(";");
    }

    public float getPrice() {
        return price;
    }

    public boolean contains(String tag) {
        for(String s : tags) {
            if(s.equals(tag)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String temp = "";
        temp += name + "\n";
        temp += " - Product ID: " + productID;
        temp += " - Price: " + price;
        temp += " - Category: " + category;
        temp += " - Quantity: " + quanitity;
        temp += " - tags: ";
        for(String s : tags) {
            temp += s + ";";
        }
        return temp;
    }
}