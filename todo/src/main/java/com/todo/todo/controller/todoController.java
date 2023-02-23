package com.todo.todo.controller;

import com.todo.todo.entity.Todo;
import com.todo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class todoController {
    @Autowired
    TodoService todoService;

    @PostMapping("/listTodos")
    public List<Todo> listTodos() {
        return todoService.findAll();
    }
    @PostMapping("/findTodo")
    public Todo findTodo(@RequestBody long id) {
        return todoService.findById(id).get();
    }

    @PostMapping("/createTodo")
    public Todo createTodo(@RequestBody String title) {
        Todo todo = new Todo();
        todo.setComplete(false);
        todo.setTitle(title);
        todoService.save(todo);
        return todo;
    }

	@PostMapping("/markTodoCompleted")
    public Todo markTodoCompleted(@RequestBody long id) {
        Todo todo = todoService.findById(id).get();
        todo.setComplete(true);
        todoService.save(todo);
        return todo;
    }
    @PostMapping("/markTodoUncompleted")
    public Todo markTodoUncompleted(@RequestBody long id) {
        Todo todo = todoService.findById(id).get();
        todo.setComplete(false);
        todoService.save(todo);
        return todo;
    }
    @PostMapping("/deleteTodo")
    public Todo deleteTodo(@RequestBody long id) {
        Todo todo = todoService.findById(id).get();
        todoService.delete(todo);
        return todo;
    }

}
