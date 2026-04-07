package hu.grofandriska.wotandme.api.service;

import hu.grofandriska.wotandme.api.model.account.AccountSearchResponse;
import hu.grofandriska.wotandme.api.model.player.PlayerPersonalData;
import hu.grofandriska.wotandme.auth.model.AppUser;
import hu.grofandriska.wotandme.auth.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final WebClient webClient;
    @Value("${app.id}")
    private String appId;

    private AppUserRepository userRepository;

    public PlayerService(WebClient webClient, AppUserRepository userRepository) {
        this.webClient = webClient;
        this.userRepository = userRepository;
    }

    public AccountSearchResponse searchPlayer(String nickname) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/wot/account/list/")
                        .queryParam("application_id", appId)
                        .queryParam("search", nickname)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<AccountSearchResponse>() {
                })
                .block();
    }

    public PlayerPersonalData getPersonalData(String nickname) {
        Optional<AppUser> user = userRepository.findByNickname(nickname);
        if (user.isPresent()) {
            return webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/wot/account/info/")
                            .queryParam("application_id", appId)
                            .queryParam("account_id", user.get().getAccountId())
                            .build()
                    )
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<PlayerPersonalData>() {
                    })
                    .block();
        } else throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User not found with nickname: " + nickname);
    }
}
