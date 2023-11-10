package com.reactive.optl.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HealthController {

    @PostMapping("/health")
    public Mono<ResponseEntity<String>> health(){
        return Mono.just(ResponseEntity.ok("Healthy"));
    }

}
