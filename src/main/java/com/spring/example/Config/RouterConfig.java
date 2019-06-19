package com.spring.example.Config;

import com.spring.example.handlers.AccountHandler;
import com.spring.example.handlers.CoachHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> accountRouterFunction(AccountHandler accountHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/v1/collection/accounts"), accountHandler::findAll)
                .andRoute(RequestPredicates.GET("/v1/account"), accountHandler::findByName)
                .andRoute(RequestPredicates.PUT("/v1/account"), accountHandler::create)
                .andRoute(RequestPredicates.DELETE("/v1/account"), accountHandler::deleteByName);
    }

    @Bean
    public RouterFunction<ServerResponse> coachRouterFunction(CoachHandler coachHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/v1/collection/coaches"), coachHandler::findAll)
                .andRoute(RequestPredicates.GET("/v1/coach"), coachHandler::findByName)
                .andRoute(RequestPredicates.PUT("/v1/coach"), coachHandler::create)
                .andRoute(RequestPredicates.DELETE("/v1/coach"), coachHandler::deleteByName);
    }


}
