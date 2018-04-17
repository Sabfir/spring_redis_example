package com.techprimers.cache.springredisexample;

import com.techprimers.cache.springredisexample.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringRedisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisExampleApplication.class, args);
	}

	@Bean
    LettuceConnectionFactory lettuceConnectionFactory() {
	    return new LettuceConnectionFactory();
    }

    @Bean
    RedisTemplate<String, User> redisTemplate() {
	    RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
	    redisTemplate.setConnectionFactory(lettuceConnectionFactory());
	    return redisTemplate;
    }
}
