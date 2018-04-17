package com.techprimers.cache.springredisexample.repository.custom_repo;

import com.techprimers.cache.springredisexample.model.User;
import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {
    private HashOperations<String, String, User> hashOperations;

    public UserCustomRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findById(String id) {
        return hashOperations.get("USER", id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(User user) {
        hashOperations.delete("USER", user.getId());
    }

    @Override
    public Long count() {
        return hashOperations.size("USER");
    }
}
