package cn.bjtu.bjtu.demofourth.controller;

import cn.bjtu.bjtu.demofourth.domain.User;
import cn.bjtu.bjtu.demofourth.services.UserService;
import cn.bjtu.bjtu.demofourth.vo.Status;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class UserHandler {
    private UserService userService;
    public UserHandler(UserService userService){
        this.userService=userService;
    }
    public Mono<ServerResponse> login(ServerRequest request) {
        final Mono<User> ll = request.bodyToMono(User.class);
        Mono<Boolean> ss=ll.flatMap(userService::login).hasElement();

        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(ss, Boolean.class);
    }
    public Mono<ServerResponse> saveuser(ServerRequest request){
        final Mono<User> ll = request.bodyToMono(User.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(ll.flatMap(userService::save), User.class));
    }
    public Mono<ServerResponse> findall(ServerRequest request){
        Flux<User> ss=userService.findAll();
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(ss, User.class);
    }
}
