package com.abrahambueno.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long todoid;

    @Column(nullable = false)
    private String description;

    private Date datestarted;
    private int completed;

    // userid foreign key
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnore
    private User useridcopy;

    public Todo() {
    }

    public Todo(String description, Date datestarted, int completed) {
        this.description = description;
        this.datestarted = datestarted;
        this.completed = completed;
//        this.useridcopy = useridcopy;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(Date datestarted) {
        this.datestarted = datestarted;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public User getUseridcopy() {
        return useridcopy;
    }

    public void setUseridcopy(User useridcopy) {
        this.useridcopy = useridcopy;
    }
}
