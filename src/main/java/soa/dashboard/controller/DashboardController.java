package soa.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public String getDashboard(){ return "index"; }

    @GetMapping("/api")
    public String getApis(){ return "redirect:/dashboard"; }

    @GetMapping("/api/template")
    public String getTemplate(){ return "TEMPLATE"; }
}
