package com.techprimers.cache.springredisexample.repository.custom_repo;

import com.techprimers.cache.springredisexample.model.User;
import java.util.Map;

public interface UserCustomRepository {

    void save(User user);

    Map<String, User> findAll();

    User findById(String id);

    void update(User user);

    void delete(User user);

    Long count();
}
