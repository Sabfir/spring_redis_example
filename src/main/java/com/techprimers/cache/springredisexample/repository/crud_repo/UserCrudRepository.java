package com.techprimers.cache.springredisexample.repository.crud_repo;

import com.techprimers.cache.springredisexample.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepository extends CrudRepository<User, String> {

    List<User> findByName(String name);

    List<User> findBySalary(Long salary);
}
