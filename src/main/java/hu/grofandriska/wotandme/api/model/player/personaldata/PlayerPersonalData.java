package hu.grofandriska.wotandme.api.model.player.personaldata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class PlayerPersonalData {
    @JsonProperty("account_id")
    private Long accountId;
    private String nickname;
    @JsonProperty("clan_id")
    private Long clanId;
    @JsonProperty("client_language")
    private String client_language;
    @JsonProperty("logout_at")
    private Long logout_at;
    @JsonProperty("updated_at")
    private Long updated_at;
    @JsonProperty("created_at")
    private Long createdAt;
    @JsonProperty("last_battle_time")
    private Long lastBattleTime;
    @JsonProperty("global_rating")
    private Integer globalRating;

    private StatisticsDTO statistics;

    @JsonProperty("private")
    private Object privateData;
}