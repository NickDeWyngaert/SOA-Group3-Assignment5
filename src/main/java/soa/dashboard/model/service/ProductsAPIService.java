package soa.dashboard.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import soa.dashboard.model.dto.*;
import soa.dashboard.model.entity.Movie;
import soa.dashboard.model.entity.Product;

import java.time.Duration;
import java.util.List;

public class ProductsAPIService {

    @Autowired
    private final WebClient productAPI;

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10); // Dit hoeft niet

    @Autowired
    public ProductsAPIService(WebClient productAPI){ this.productAPI = productAPI; }

    public List<Product> read() { return this.requestAllProducts().getData(); }
    private DataProduct requestAllProducts(){
        return productAPI
                .get()
                .uri("/")
                .retrieve()
                .bodyToMono(DataProduct.class)
                .block(REQUEST_TIMEOUT);
    }

    public Product readOne(int id){ return requestOneProduct(id); }
    private Product requestOneProduct(int id){
        return productAPI
                .get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Product.class)
                .block(REQUEST_TIMEOUT);
    }

    public ProductDTO create(ProductDTO productDTO) { return requestCreateProduct(productDTO); }
    private ProductDTO requestCreateProduct(ProductDTO productDTO){
        return productAPI
                .post()
                .uri("/")
                .body(Mono.just(new OnlyProductObject(productDTO)), OnlyMovieObject.class)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public ProductDTO update(int id, ProductDTO productDTO) { return requestUpdateProduct(id,productDTO); }
    private ProductDTO requestUpdateProduct(int id, ProductDTO productDTO){
        return productAPI
                .put()
                .uri("/" + id)
                .body(Mono.just(new OnlyProductObject(productDTO)), OnlyProductObject.class)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public void delete(int id) { this.requestDeleteProduct(id); }
    private void requestDeleteProduct(int id){
        productAPI
                .delete()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(REQUEST_TIMEOUT);
    }

}
