package cn.bjtu.bjtu.demofourth.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> route(UserHandler handler) {
        return RouterFunctions
                .route(POST("/login").and(accept(MediaType.APPLICATION_JSON)), handler::login)
                .andRoute(POST("/save").and(accept(MediaType.APPLICATION_JSON)), handler::saveuser)
                .andRoute(GET("/findall").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findall);
    }
}