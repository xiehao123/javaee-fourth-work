package com.spring.example.repositories;

import com.spring.example.models.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
    Mono<Account> findByName(String name);
    Mono<Long> deleteByName(String name);
}
