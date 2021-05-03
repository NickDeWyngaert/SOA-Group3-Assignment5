package soa.dashboard.model.dto;

import soa.dashboard.model.entity.Product;

import java.util.Objects;

public class ProductDTO {
    private String name;
    private String description;
    private double price;

    public ProductDTO() {}

    public ProductDTO(String name, String description, double price){
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);

    }



    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO product = (ProductDTO) o;
        return  price == product.price && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, description);
    }
}
