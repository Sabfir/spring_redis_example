# SPRING DATA REDIS SIMPLE EXAMPLE
###1. Technologies
* Java 1.8
* Maven 4.0
* Spring Data Redis (with lettuce as a redis provider)
* Spring Web (REST)

###2. Two variants are implemented:
- <u>Spring Data CrudRepository:</u> <i>see class UserCrudRepository.java</i>
- <u>low level usage of RedisTemplate:</u> <i>see interface UserCustomRepository.java and its implementation UserCustomRepositoryImpl.java</i>

###3. Other Features
- Partial Update. See SpringRedisExampleApplication.java:
```
    RedisKeyValueTemplate template = context.getBean(RedisKeyValueTemplate.class);
    template.update(PartialUpdate.newPartialUpdate(rand.getId(), User.class).set("salary", 150L));
```