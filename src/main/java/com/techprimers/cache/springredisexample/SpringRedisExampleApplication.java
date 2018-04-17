package com.techprimers.cache.springredisexample;

import com.techprimers.cache.springredisexample.model.User;
import com.techprimers.cache.springredisexample.repository.crud_repo.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.RedisKeyValueTemplate;

@SpringBootApplication
public class SpringRedisExampleApplication {
    @Autowired
    private UserCrudRepository repo;
//    private UserCustomRepository repo;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringRedisExampleApplication.class, args);
        context.getBean(SpringRedisExampleApplication.class).run(context);
    }

    private void run(ConfigurableApplicationContext context) {
        User rand = new User("rand", "sabfir", 100L);

        repo.save(rand);
        System.out.println("save: " + rand);

        System.out.println("findById: " + repo.findById(rand.getId()));

        System.out.println("count: " + repo.count());

        RedisKeyValueTemplate template = context.getBean(RedisKeyValueTemplate.class);
        template.update(PartialUpdate.newPartialUpdate(rand.getId(), User.class).set("salary", 150L));

        System.out.println("findByName after partial update: " + repo.findByName("sabfir"));

        repo.delete(rand);
        System.out.println("delete");

        System.out.println("findByName: " + repo.findByName("sabfir"));
    }
}
