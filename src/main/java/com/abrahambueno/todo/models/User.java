package com.abrahambueno.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    @Column(nullable = false)
    private String username;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "userid")
    @JsonIgnore
    private Set<Todo> todos;

    public User() {
    }

//    public User(String username) {
//        this.username = username;
//    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
