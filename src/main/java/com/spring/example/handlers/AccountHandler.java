package com.spring.example.handlers;

import com.spring.example.models.Account;
import com.spring.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class AccountHandler {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountHandler(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        if (request.queryParam("name").orElse("").equals("") || request.queryParam("name").orElse("").equals("") || request.queryParam("name").orElse("").equals("") || request.queryParam("name").orElse("").equals("")) {
            return ServerResponse.ok().body(fromObject("Invalid Parameters"));
        }
        Account account = new Account(request.queryParam("name").get(), request.queryParam("mobile").get(), request.queryParam("address").get(), request.queryParam("password").get());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body( accountRepository.save(account), Account.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body( accountRepository.findAll(), Account.class);
    }

    public Mono<ServerResponse> findByName(ServerRequest request) {
        String name = request.queryParam("name").orElse("unknown");
        Mono<ServerResponse> notFound= ServerResponse.notFound().build();
        return accountRepository.findByName(name).flatMap(account -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(account)).switchIfEmpty(notFound));
    }

    public Mono<ServerResponse> deleteByName(ServerRequest request) {
        String name = request.queryParam("name").orElse("unknown");
        return accountRepository.deleteByName(name).flatMap(mono -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                fromObject(Mono.just("Deleted"))
        ));
    }
}
