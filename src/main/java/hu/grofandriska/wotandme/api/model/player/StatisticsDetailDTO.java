package hu.grofandriska.wotandme.api.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticsDetailDTO {
    private Integer battles;
    private Integer wins;
    private Integer losses;
    private Integer draws;
    private Integer frags;
    private Integer spotted;
    private Integer hits;
    private Integer shots;


    private Long xp;
    @JsonProperty("damage_dealt")
    private Long damageDealt;
    @JsonProperty("damage_received")
    private Long damageReceived;
    @JsonProperty("capture_points")
    private Long capturePoints;
    @JsonProperty("dropped_capture_points")
    private Long droppedCapturePoints;

    @JsonProperty("tanking_factor")
    private Double tankingFactor;
    @JsonProperty("hits_percents")
    private Double hitsPercents;
    @JsonProperty("avg_damage_blocked")
    private Double avgDamageBlocked;

    // Assisted damage csoport
    @JsonProperty("avg_damage_assisted")
    private Double avgDamageAssisted;
    @JsonProperty("avg_damage_assisted_track")
    private Double avgDamageAssistedTrack;
    @JsonProperty("avg_damage_assisted_radio")
    private Double avgDamageAssistedRadio;
    @JsonProperty("avg_damage_assisted_stun")
    private Double avgDamageAssistedStun;

    @JsonProperty("max_damage")
    private Integer maxDamage;
    @JsonProperty("max_damage_tank_id")
    private Long maxDamageTankId;

    @JsonProperty("max_xp")
    private Integer maxXp;
    @JsonProperty("max_xp_tank_id")
    private Long maxXpTankId;

    @JsonProperty("max_frags")
    private Integer maxFrags;
    @JsonProperty("max_frags_tank_id")
    private Long maxFragsTankId;
}
