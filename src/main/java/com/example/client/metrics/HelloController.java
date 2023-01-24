package com.example.client.metrics;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final IpService client;
    @GetMapping("/ping")
    public Mono<String> authorize() {
        return client.getMyIp().map(ip -> "hello from " + ip);
    }
}
