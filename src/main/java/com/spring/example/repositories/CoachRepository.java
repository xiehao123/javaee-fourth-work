package com.spring.example.repositories;

import com.spring.example.models.Coach;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CoachRepository extends ReactiveMongoRepository<Coach, String> {
    Mono<Coach> findByName(String name);
    Mono<Long> deleteByName(String name);
}
