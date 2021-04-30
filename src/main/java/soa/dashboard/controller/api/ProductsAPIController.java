package soa.dashboard.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/api/products")
public class ProductsAPIController {

    @GetMapping
    public String getOverviewProducts(){
        return "api-products";
    }

}
