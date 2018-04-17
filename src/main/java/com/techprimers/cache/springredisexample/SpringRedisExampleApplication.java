package com.techprimers.cache.springredisexample;

import com.techprimers.cache.springredisexample.model.User;
import com.techprimers.cache.springredisexample.repository.crud_repo.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringRedisExampleApplication {
    @Autowired
    private UserCrudRepository repo;
//    private UserCustomRepository repo;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringRedisExampleApplication.class, args);
        context.getBean(SpringRedisExampleApplication.class).run();
    }

    private void run() {
        User rand = new User("rand", "al'thor", 100L);

        repo.save(rand);
        System.out.println("save: " + rand);

        System.out.println("findById: " + repo.findById(rand.getId()));

        System.out.println("count: " + repo.count());

        repo.delete(rand);
        System.out.println("delete");
    }
}
