package com.example.client.metrics;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class IpService {

    private WebClient webClient;

    public IpService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.myip.com/").build();
    }

    public Mono<String> getMyIp() {
        return this.webClient.get()
                .retrieve().bodyToMono(String.class);
    }

    //https://api.open-meteo.com/v1/forecast?latitude=52.103399&longitude=4.263091&current_weather=true
}
