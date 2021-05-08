package soa.dashboard.model.dto;

public class OnlyToDoItemObject {

    private ToDoItemDTO toDoItemDTO;

    public OnlyToDoItemObject() {
    }

    public OnlyToDoItemObject(ToDoItemDTO todoitem) {
        setToDoItemDTO(todoitem);
    }

    public ToDoItemDTO getToDoItemDTO() {
        return toDoItemDTO;
    }

    public void setToDoItemDTO(ToDoItemDTO toDoItemDTO) {
        this.toDoItemDTO = toDoItemDTO;
    }
}
