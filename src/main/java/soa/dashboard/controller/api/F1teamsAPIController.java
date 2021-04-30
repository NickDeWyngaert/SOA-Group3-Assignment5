package soa.dashboard.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/api/f1teams")
public class F1teamsAPIController {

    @GetMapping
    public String getOverviewF1teams(){
        return "api-f1teams";
    }

}
