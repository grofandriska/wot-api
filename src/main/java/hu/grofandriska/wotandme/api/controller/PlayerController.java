package hu.grofandriska.wotandme.api.controller;


import hu.grofandriska.wotandme.api.model.account.AccountSearchResponse;
import hu.grofandriska.wotandme.api.model.player.personaldata.PlayerPersonalDataWrapper;
import hu.grofandriska.wotandme.api.model.player.tankstats.DetailedTankStatsWrapper;
import hu.grofandriska.wotandme.api.model.player.vehicles.PlayerTankStatsWrapper;
import hu.grofandriska.wotandme.api.service.PlayerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/data")
    public ResponseEntity<PlayerPersonalDataWrapper> getPersonalData(@RequestParam String nickname) {
        PlayerPersonalDataWrapper response = service.getPersonalData(nickname);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<PlayerTankStatsWrapper> getPlayersVehicles(@RequestParam String nickname) {
        PlayerTankStatsWrapper response = service.getPlayersVehicles(nickname);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/vehicles/stats")
    public ResponseEntity<DetailedTankStatsWrapper> getPlayersVehiclesStats(@RequestParam String nickname) {
        DetailedTankStatsWrapper response = service.getPlayersVehiclesStats(nickname);
        return ResponseEntity.ok(response);
    }
}
