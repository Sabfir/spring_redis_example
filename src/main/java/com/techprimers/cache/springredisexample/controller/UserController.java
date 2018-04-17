package com.techprimers.cache.springredisexample.controller;

import com.techprimers.cache.springredisexample.repository.crud_repo.UserCrudRepository;
import com.techprimers.cache.springredisexample.model.User;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserController {
    private UserCrudRepository repository;
//    private UserCustomRepository repository;

    public UserController(UserCrudRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable String id, @PathVariable String name) {
        repository.save(new User(id, name, 20000L));
        return repository.findById(id).get();
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable String id, @PathVariable String name) {
        repository.save(new User(id, name, 1000L));
        return repository.findById(id).get();
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable String id) {
        return repository.findById(id).get();
    }
}
