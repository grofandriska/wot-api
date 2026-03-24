package hu.grofandriska.wotandme.api.controller;


import hu.grofandriska.wotandme.api.model.account.AccountSearchResponse;
import hu.grofandriska.wotandme.api.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wot/player")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public ResponseEntity<AccountSearchResponse> search(@RequestParam String nickname) {
        AccountSearchResponse response = service.searchPlayer(nickname);
        return ResponseEntity.ok(response);
    }
}
