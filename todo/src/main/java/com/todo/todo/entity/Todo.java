package com.todo.todo.entity;

import jakarta.persistence.*;
import lombok.Data;
// import com.fasterxml.jackson.annotation.JsonIgnore;
// import org.hibernate.annotations.OnDelete;
// import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "todos", uniqueConstraints = @UniqueConstraint(columnNames = {"title"}))
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean isComplete;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "userId", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private User user;
}
