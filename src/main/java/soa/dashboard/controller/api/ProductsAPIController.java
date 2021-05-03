package soa.dashboard.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import soa.dashboard.model.dto.MovieDTO;
import soa.dashboard.model.dto.ProductDTO;
import soa.dashboard.model.entity.Movie;
import soa.dashboard.model.entity.Product;
import soa.dashboard.model.service.MoviesAPIService;
import soa.dashboard.model.service.ProductsAPIService;

import java.util.List;

@Controller
@RequestMapping("/dashboard/api/products")
public class ProductsAPIController {

    private final ProductsAPIService service;

    @Autowired
    public ProductsAPIController(WebClient productsAPI){
        this.service = new ProductsAPIService(productsAPI);
    }


    /*
        READ
    */
    @GetMapping
    public String getOverviewMovies(Model model){
        List<Product> movies = this.service.read();
        model.addAttribute("products",movies);
        return "api-products";
    }
    @GetMapping("/{id}")
    public String showOneMovie(@PathVariable int id, Model model){
        model.addAttribute("product",this.service.readOne(id));
        return "api-products-product";
    }


    /*
        CREATE
    */
    @GetMapping("/new")
    public String getNewProduct(Model model){
        model.addAttribute("product",new ProductDTO());
        return "api-products-new";
    }
    @PostMapping("/new")
    public String postNewProduct(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "price") double price

    ){

        ProductDTO gotfromhtml = new ProductDTO(name,description,price);
        ProductDTO receivedProduct = this.service.create(gotfromhtml);
        return "redirect:/dashboard/api/products";
    }


    /*
        UPDATE
    */
    @GetMapping("/{id}/update")
    public String getUpdateMovie(@PathVariable int id, Model model){
        Product product = this.service.readOne(id);
        model.addAttribute("id",id);
        model.addAttribute("product",product);
        return "api-products-update";
    }
    @PostMapping("/{id}/update")
    public String postUpdateMovie(
            @PathVariable int id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "price") double price

    ){
        /*
            @ModelAttribute MovieDTO movie
            Werkt niet om één of andere reden?
        */
        ProductDTO gotfromhtml = new ProductDTO(name,description,price);
        ProductDTO receivedProduct = this.service.update(id,gotfromhtml);
        return "redirect:/dashboard/api/products/" + id;
    }


    /*
        DELETE
    */
    @GetMapping("/{id}/delete")
    public String deleteMovie(@PathVariable int id){
        this.service.delete(id);
        return "redirect:/dashboard/api/product";
    }


}
