package com.todo.entity;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {

    public Todo() {
    }

    public Todo(Long id, String task, Long priority) {
        this.id = id;
        this.task = task;
        this.priority = priority;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(length = 300, nullable = false)
    private String task;

    @Column(nullable = false)
    private Long priority;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public Long getPriority() {
        return priority;
    }
}
