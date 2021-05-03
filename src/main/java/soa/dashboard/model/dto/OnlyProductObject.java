package soa.dashboard.model.dto;

import soa.dashboard.model.entity.Product;

public class OnlyProductObject {
    private ProductDTO product;

    public OnlyProductObject() {}

    public OnlyProductObject(ProductDTO product) {
        this.setProduct(product);
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
