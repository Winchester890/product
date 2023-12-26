package product.api.com.entities;

public class Product {
    private Integer id;
    private String name;
    private Integer quantity;
    private Double price;
    private Double maxDiscount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public Product(Integer id, String name, Integer quantity, Double price, Double maxDiscount){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.maxDiscount = maxDiscount;
    }
}
