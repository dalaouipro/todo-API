package com.todo.todo.service;

import com.todo.todo.entity.Todo;
import com.todo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> findAll() {return todoRepository.findAll();}
    public Optional<Todo> findById(int id) {return todoRepository.findById(id);}
    public List<Todo> findByTitle(String title) {return todoRepository.findByTitle(title);}
    public void save (Todo todo) {todoRepository.save(todo);}
    public void delete (Todo todo) {todoRepository.delete(todo);}
}
