package com.reactive01.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class Handler {
  public Mono<ServerResponse> helloWorld(ServerRequest request) {
    String id = request.pathVariable("id");
    Mono<UserVO> helloworldMono = Mono.just(new UserVO(1L, id, "hi"));
    return ServerResponse.ok().body(helloworldMono, UserVO.class);
  }
}
