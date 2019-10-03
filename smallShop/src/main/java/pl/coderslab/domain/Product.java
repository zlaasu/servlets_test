package pl.coderslab.domain;

public class Product {
    private Long id;
    private String name;
    private String shortDescription;
    private float price;

    public Product() {
    }

    public Product(Long id, String name, String shortDescription, float price) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
