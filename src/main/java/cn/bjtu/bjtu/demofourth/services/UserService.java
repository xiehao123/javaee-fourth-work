package cn.bjtu.bjtu.demofourth.services;

import cn.bjtu.bjtu.demofourth.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {
    Mono<User> findById(String id);
    Flux<User> findAll();
    Mono<User> save(User user);
    Mono<Void> deleteById(String id);
    Mono<User> login(User user);
}