package soa.dashboard.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import soa.dashboard.model.dto.F1DTO;
import soa.dashboard.model.entity.F1;
import soa.dashboard.model.service.F1teamsAPIService;

import java.util.List;

@Controller
@RequestMapping("/dashboard/api/f1teams")
public class F1teamsAPIController {


    private final F1teamsAPIService service;

    @Autowired
    public F1teamsAPIController(WebClient f1teamsAPI){
        this.service = new F1teamsAPIService(f1teamsAPI);
    }



    @GetMapping
    public String getOverviewF1teams(Model model){

        List<F1> f1teams = this.service.read();
        model.addAttribute("f1teams",f1teams);
        return "api-f1teams";
    }

    @GetMapping("/{id}/update")
    public String getUpdateF1team(@PathVariable int id, Model model){
        F1 f1 = this.service.readOne(id);
        model.addAttribute("id",id);
        model.addAttribute("f1",f1);
        return "api-f1teams-update";
    }

    @PostMapping("{id}/update")
    public String postUpdateF1team(
            @PathVariable int id,
            @RequestParam(name = "naam") String naam,
            @RequestParam(name = "budget") String budget,
            @RequestParam(name = "beschrijving") String beschrijving
    ){
        F1DTO fromhtml = new F1DTO(naam, budget, beschrijving);
        F1DTO receivedf1team = this.service.update(id,fromhtml);
        return "redirect:/dashboard/api/f1teams/" + id;
    }

    @GetMapping("/{id}/delete")
    public String deleteF1team(@PathVariable int id){
        this.service.delete(id);
        return "redirect:/dashboard/api/f1teams";
    }

    @GetMapping("/new")
    public String getNewF1team(Model model){
        model.addAttribute("f1team",new F1DTO());
        return "api-f1teams-add";
    }
    @PostMapping("/new")
    public String postNewF1team(
            @RequestParam(name = "naam") String naam,
            @RequestParam(name = "budget") String budget,
            @RequestParam(name = "beschrijving") String beschrijving
    ){

        F1DTO gotfromhtml = new F1DTO(naam, budget, beschrijving);
        F1DTO receivedF1Team = this.service.create(gotfromhtml);
        return "redirect:/dashboard/api/f1teams";
    }

    @GetMapping("/{id}")
    public String getOneF1team(@PathVariable int id, Model model){
        model.addAttribute("f1team",this.service.readOne(id));
        return "api-f1teams-f1team";
    }


}
