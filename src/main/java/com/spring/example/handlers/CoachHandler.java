package com.spring.example.handlers;
import com.spring.example.models.Coach;
import com.spring.example.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class CoachHandler {


    private final CoachRepository coachRepository;

    @Autowired
    public CoachHandler(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        if (request.queryParam("name").orElse("").equals("") || request.queryParam("mobile").orElse("").equals("")) {
            return ServerResponse.ok().body(fromObject("Invalid Parameters"));
        }
        Coach account = new Coach(request.queryParam("name").get(), request.queryParam("mobile").get());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body( coachRepository.save(account), Coach.class);
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body( coachRepository.findAll(), Coach.class);
    }

    public Mono<ServerResponse> findByName(ServerRequest request) {
        String name = request.queryParam("name").orElse("unknown");
        Mono<ServerResponse> notFound= ServerResponse.notFound().build();
        return coachRepository.findByName(name).flatMap(coach -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(coach))
                .switchIfEmpty(notFound));
    }

    public Mono<ServerResponse> deleteByName(ServerRequest request) {
        String name = request.queryParam("name").orElse("unknown");
        return coachRepository.deleteByName(name).flatMap(mono -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(
                fromObject(Mono.just("Deleted"))
        ));
    }
}
