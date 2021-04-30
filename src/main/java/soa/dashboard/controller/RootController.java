package soa.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {

    @GetMapping
    public String getRoot(){ return "redirect:/dashboard"; }

    @PostMapping
    public String postRoot(){ return "redirect:/dashboard"; }

}
