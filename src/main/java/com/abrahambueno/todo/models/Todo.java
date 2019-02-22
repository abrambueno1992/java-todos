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
    private boolean completed;

    // userid foreign key
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnore
    private User userid;
}
