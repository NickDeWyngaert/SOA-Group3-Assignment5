package soa.dashboard.model.entity;

import java.util.Objects;

public class ToDoItem {

    private int id;
    private String name, course, task;

    public ToDoItem(){
    }

    public ToDoItem(int id, String name, String course, String task) {
        setId(id);
        setName(name);
        setCourse(course);
        setTask(task);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", task='" + task + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return id == toDoItem.id && Objects.equals(name, toDoItem.name) && Objects.equals(course, toDoItem.course) && Objects.equals(task, toDoItem.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, course, task);
    }
}
