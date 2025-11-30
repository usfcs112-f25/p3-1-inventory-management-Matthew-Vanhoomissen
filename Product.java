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
}