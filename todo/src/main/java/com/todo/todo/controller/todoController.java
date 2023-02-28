package com.todo.todo.controller;

import com.todo.todo.entity.Todo;
import com.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class todoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/listTodos")
    public List<Todo> listTodos() {
        return todoService.findAll();
    }

    @GetMapping("/findTodo/{id}")
    public Todo findTodo(@PathVariable int id) {
        return todoService.findById(id).get();
    }

    @PostMapping("/createTodo")
    public Todo createTodo( @RequestBody String title) {
        Todo todo = new Todo();
        todo.setComplete(false);
        todo.setTitle(title);
        todoService.save(todo);
        return todo;
    }

    @PutMapping("/updateTodo/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody String title) {
        Todo todo = findTodo(id);
        todo.setTitle(title);
        todoService.save(todo);
        return todo;
    }

	@PutMapping("/markTodoCompleted/{id}")
    public Todo markTodoCompleted(@PathVariable int id) {
        Todo todo = todoService.findById(id).get();
        todo.setComplete(true);
        todoService.save(todo);
        return todo;
    }

    @PutMapping("/markTodoUncompleted/{id}")
    public Todo markTodoUncompleted(@PathVariable int id) {
        Todo todo = todoService.findById(id).get();
        todo.setComplete(false);
        todoService.save(todo);
        return todo;
    }

    @DeleteMapping("/deleteTodo/{id}")
    public Todo deleteTodo(@PathVariable int id) {
        Todo todo = todoService.findById(id).get();
        todoService.delete(todo);
        return todo;
    }

}
