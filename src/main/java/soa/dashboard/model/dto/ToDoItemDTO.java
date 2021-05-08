package soa.dashboard.model.dto;

import soa.dashboard.model.entity.ToDoItem;

import java.util.Objects;

public class ToDoItemDTO {

    private String name, course, task;

    public ToDoItemDTO() {
    }

    public ToDoItemDTO(String name, String course, String task) {
        this.name = name;
        this.course = course;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "ToDoItemDTO{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", task='" + task + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItemDTO that = (ToDoItemDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(course, that.course) && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course, task);
    }
}
