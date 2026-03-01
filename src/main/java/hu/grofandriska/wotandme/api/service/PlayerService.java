package hu.grofandriska.wotandme.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PlayerService {

    private final WebClient webClient;
    @Value("${app.id}")
    private String appId;

    public PlayerService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String searchPlayer(String nickname) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/wot/account/list/")
                        .queryParam("application_id", appId)
                        .queryParam("search", nickname)
                        .build()
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
