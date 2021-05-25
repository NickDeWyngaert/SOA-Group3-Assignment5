package soa.dashboard.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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

    public List<Product> read() { return this.requestAllProducts(); }
    private List requestAllProducts(){
        return productAPI
                .get()
                .uri("/all")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List>() {})
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
                .uri("/create")
                .body(Mono.just(productDTO), ProductDTO.class)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public ProductDTO update(int id, ProductDTO productDTO) { return requestUpdateProduct(id,productDTO); }
    private ProductDTO requestUpdateProduct(int id, ProductDTO productDTO){
        return productAPI
                .put()
                .uri("/edit/" + id)
                .body(Mono.just(productDTO), ProductDTO.class)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public void delete(int id) { this.requestDeleteProduct(id); }
    private void requestDeleteProduct(int id){
        productAPI
                .delete()
                .uri("/delete/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(REQUEST_TIMEOUT);
    }

}
