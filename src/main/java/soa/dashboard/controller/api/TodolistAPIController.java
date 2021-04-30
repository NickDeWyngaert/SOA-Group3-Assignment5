package soa.dashboard.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/api/todolist")
public class TodolistAPIController {

    @GetMapping
    public String getOverviewTodolistitems(){
        return "api-todolist";
    }

}
