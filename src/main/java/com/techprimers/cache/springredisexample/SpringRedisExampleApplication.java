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
        User user = new User("rand", "sabfir", 100L);

        System.out.println("save: " + repo.save(user));

        System.out.println("findById: " + repo.findById(user.getId()));

        // partial update
        RedisKeyValueTemplate template = context.getBean(RedisKeyValueTemplate.class);
        template.update(PartialUpdate.newPartialUpdate(user.getId(), User.class).set("salary", 150L));
        System.out.println("findByName after partial update: " + repo.findByName("sabfir"));

        System.out.println("count: " + repo.count());

        repo.delete(user);
        System.out.println("delete");

        // getting not existent value
        System.out.println("findByName: " + repo.findByName("sabfir"));

        // ttl testing
        user.setTtl(1L);
        System.out.println("save: " + repo.save(user));
        System.out.println("findById BEFORE ttl expired: " + repo.findById(user.getId()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("findById AFTER ttl expired: " + repo.findById(user.getId()));
    }
}
