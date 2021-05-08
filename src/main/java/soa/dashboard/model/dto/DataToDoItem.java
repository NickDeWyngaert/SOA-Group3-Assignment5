package soa.dashboard.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import soa.dashboard.model.entity.ToDoItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataToDoItem {

    private List<ToDoItem> data;

    public DataToDoItem() {this.data = new ArrayList<>();}

    public DataToDoItem(List<ToDoItem> data) { this.setData(data);}

    public List<ToDoItem> getData() {
        return data;
    }

    public void setData(List<ToDoItem> data) {
        this.data = data;
    }
}
