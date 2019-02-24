package com.abrahambueno.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long todoid;

    @Column(nullable = false)
    private String description;

    private String datestarted;
    private int completed;

    // userid foreign key
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnore
    private User userid;

    public Todo() {
    }

//    public Todo(String description, String datestarted, int completed, User useridcopy) {
//        this.description = description;
//        this.datestarted = datestarted;
//        this.completed = completed;
//        this.useridcopy = useridcopy;
//    }

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

    public String getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(String datestarted) {
        this.datestarted = datestarted;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }
}
