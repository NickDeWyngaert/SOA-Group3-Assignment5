package soa.dashboard.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import soa.dashboard.model.dto.*;
import soa.dashboard.model.entity.ToDoItem;

import java.time.Duration;
import java.util.List;

@Service
public class TodolistAPIService {

    @Autowired
    private final WebClient todolistAPI;

    private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10); // Dit hoeft niet

    @Autowired
    public TodolistAPIService(WebClient todolistAPI){ this.todolistAPI = todolistAPI;}

    public List read() {return this.requestAllTodoitems();}
    private List requestAllTodoitems(){
        return todolistAPI
                .get()
                .uri("")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List>() {})
                .block(REQUEST_TIMEOUT);
    }

    public ToDoItem readOne(int id){ return requestOneTodoitem(id);}
    private ToDoItem requestOneTodoitem(int id){
        return todolistAPI
                .get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(ToDoItem.class)
                .block(REQUEST_TIMEOUT);
    }


    public ToDoItemDTO create(ToDoItemDTO todoitem) { return requestCreateTodoitem(todoitem);}
    private ToDoItemDTO requestCreateTodoitem(ToDoItemDTO todoitem) {
        return todolistAPI
                .post()
                .uri("")
                .body(Mono.just(todoitem), ToDoItemDTO.class)
                .retrieve()
                .bodyToMono(ToDoItemDTO.class)
                .block(REQUEST_TIMEOUT);
    }

    public void delete(int id) { this.requestDeleteTodoitem(id);}
    private void requestDeleteTodoitem(int id){
        todolistAPI
                .delete()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block(REQUEST_TIMEOUT);
    }

    public ToDoItemDTO update(int id,ToDoItemDTO todoitem) { return requestUpdateTodoitem(id, todoitem); }
    private ToDoItemDTO requestUpdateTodoitem(int id, ToDoItemDTO todoitem) {
        return todolistAPI
                .put()
                .uri("/" + id)
                .body(Mono.just(todoitem), ToDoItemDTO.class)
                .retrieve()
                .bodyToMono(ToDoItemDTO.class)
                .block(REQUEST_TIMEOUT);
    }
}
