package cn.bjtu.bjtu.demofourth.dao;

import cn.bjtu.bjtu.demofourth.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository  extends ReactiveMongoRepository<User, String> {


    Mono<User> findByNameAndPassword(String name, String password);


    Mono<Void> deleteByName(String name);
}
