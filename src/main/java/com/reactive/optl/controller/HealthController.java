package com.reactive.optl.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.time.Instant;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HealthController {

    @PostMapping("/health")
    public Mono<ResponseEntity<String>> health() {
        log.info("Request Received at : {}", Instant.now());
        return Mono.just(ResponseEntity.ok("Healthy"));
    }


    @PostMapping("/web-client-endpoint")
    public Mono<ResponseEntity<String>> callEndpoint() {
        return WebClient.builder().baseUrl("http://localhost:8080/health").build().post().retrieve().bodyToMono(String.class).map(response -> {
            log.info("Response Received: {}", response);
            return ResponseEntity.ok(response);
        });
    }

}
