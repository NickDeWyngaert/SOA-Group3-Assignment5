package soa.dashboard.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import soa.dashboard.model.dto.ToDoItemDTO;
import soa.dashboard.model.entity.ToDoItem;
import soa.dashboard.model.service.TodolistAPIService;

import java.util.List;

@Controller
@RequestMapping("/dashboard/api/todolist")
public class TodolistAPIController {

    private final TodolistAPIService service;

    @Autowired
    public TodolistAPIController(@Qualifier("todolistAPI") WebClient todoAPI){this.service = new TodolistAPIService(todoAPI);}


    /*
        READ
    */
    @GetMapping
    public String getOverviewTodolistitems(Model model){
        List<ToDoItem> toDoItemList = this.service.read();
        model.addAttribute("todolist", toDoItemList);
        return "api-todolist";
    }

    @GetMapping("/{id}")
    public String getOneTodoitem(@PathVariable int id, Model model){
        model.addAttribute("todoitem",this.service.readOne(id));
        return "api-todolist-todoitem";
    }

    /*
        CREATE
    */
    @GetMapping("/new")
    public String getNewTodoitem(Model model){
        model.addAttribute("todoitem", new ToDoItemDTO());
        return "api-todolist-new";
    }
    @PostMapping("/new")
    public String postNewTodoitem(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "course") String course,
            @RequestParam(name = "task") String task
    ) {
        ToDoItemDTO fromhtml = new ToDoItemDTO(name, course, task);
        ToDoItemDTO receivedTodoitem = this.service.create(fromhtml);
        return "redirect:/dashboard/api/todolist";
    }

    /*
        UPDATE
    */
    @GetMapping("{id}/update")
    public String getUpdateMovie(@PathVariable int id, Model model){
        ToDoItem toDoItem = this.service.readOne(id);
        model.addAttribute("id",id);
        model.addAttribute("todoitem", toDoItem);
        return "api-todolist-update";
    }

    @PostMapping("{id}/update")
    public String postUpdateTodoitem(
            @PathVariable int id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "course") String course,
            @RequestParam(name = "task") String task
    ){
        ToDoItemDTO fromhtml = new ToDoItemDTO(name, course, task);
        ToDoItemDTO receivedTodoitem = this.service.update(id,fromhtml);
        return "redirect:/dashboard/api/todolist/" + id;
    }


    /*
        DELETE
     */
    @GetMapping("/{id}/delete")
    public String deleteTodoitem(@PathVariable int id){
        this.service.delete(id);
        return "redirect:/dashboard/api/todolist";
    }


}
