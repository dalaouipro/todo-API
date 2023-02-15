package com.todo.todo.service;

import com.todo.todo.entity.User;
import com.todo.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
    public List<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void save (User user) {userRepository.save(user); }
    public void delete (User user) {userRepository.delete(user);}
}
