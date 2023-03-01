package pl.asia.infrastructure.entity;

public class Plant {

    private Long id;
    private final String name;
    private final String type;
    private final String producer;
    private final double price;
    private final String specification;

    public Plant(Long id, String name, String type, String producer, double price, String specification) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.producer = producer;
        this.price = price;
        this.specification = specification;
    }

    public Plant(String name, String type, String producer, double price, String specification) {
        this.name = name;
        this.type = type;
        this.producer = producer;
        this.price = price;
        this.specification = specification;
    }

    public Long getId() {return id;}

    public String getName() {return name;}

    public String getType() {return type;}

    public String getProducer() {return producer;}

    public double getPrice() {return price;}

    public String getSpecification() {return specification;}

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", specification='" + specification + '\'' +
                '}';
    }
}
