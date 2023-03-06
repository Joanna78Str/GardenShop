package pl.asia.infrastructure.entity;

public class Order {

    private Long id;
    private final String productName;
    private final int quantity;
    private final double price;

    public Order(Long id, String productName, int quantity, double price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public Order(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {return id;}

    public String getProductName() {return productName;}

    public int getQuantity() {return quantity;}

    public double getPrice() {return price;}

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

