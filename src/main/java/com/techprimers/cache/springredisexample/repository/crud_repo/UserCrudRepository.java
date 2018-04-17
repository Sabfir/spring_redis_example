package com.techprimers.cache.springredisexample.repository.crud_repo;

import com.techprimers.cache.springredisexample.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<User, String> {
}