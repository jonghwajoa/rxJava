package com.reactive01.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class DemoApplication implements WebFluxConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }


  @Bean
  public RouterFunction<ServerResponse> routes(Handler handler) {
    return RouterFunctions
            .route(RequestPredicates.GET("/{id}"), handler::helloWorld);
  }
}
