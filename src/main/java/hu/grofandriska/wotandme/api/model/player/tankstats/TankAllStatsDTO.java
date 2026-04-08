package hu.grofandriska.wotandme.api.model.player.tankstats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class TankAllStatsDTO {

    // Alap statisztikák
    private Integer battles;
    private Integer wins;
    private Integer losses;
    private Integer draws;
    private Integer frags;
    private Integer spotted;
    private Integer shots;
    private Integer hits;

    // Nagy értékek (Sebzés és XP)
    private Long xp;
    @JsonProperty("damage_dealt")
    private Long damageDealt;
    @JsonProperty("damage_received")
    private Long damageReceived;
    @JsonProperty("battle_avg_xp")
    private Integer battleAvgXp;

    // Tört számok (Átlagok és szorzók)
    @JsonProperty("hits_percents")
    private Double hitsPercents;
    @JsonProperty("tanking_factor")
    private Double tankingFactor;
    @JsonProperty("avg_damage_blocked")
    private Double avgDamageBlocked;

    // Assisted (Segített) sebzések
    @JsonProperty("avg_damage_assisted")
    private Double avgDamageAssisted;
    @JsonProperty("avg_damage_assisted_track")
    private Double avgDamageAssistedTrack;
    @JsonProperty("avg_damage_assisted_radio")
    private Double avgDamageAssistedRadio;
    @JsonProperty("avg_damage_assisted_stun")
    private Double avgDamageAssistedStun;

    @JsonProperty("stun_assisted_damage")
    private Long stunAssistedDamage;
    @JsonProperty("stun_number")
    private Integer stunNumber;

    // Találati statisztikák
    @JsonProperty("direct_hits_received")
    private Integer directHitsReceived;
    @JsonProperty("explosion_hits")
    private Integer explosionHits;
    @JsonProperty("explosion_hits_received")
    private Integer explosionHitsReceived;
    @JsonProperty("piercings")
    private Integer piercings;
    @JsonProperty("piercings_received")
    private Integer piercingsReceived;
    @JsonProperty("no_damage_direct_hits_received")
    private Integer noDamageDirectHitsReceived;

    // Életbenmaradás és objektívák
    @JsonProperty("survived_battles")
    private Integer survivedBattles;
    @JsonProperty("capture_points")
    private Integer capturePoints;
    @JsonProperty("dropped_capture_points")
    private Integer droppedCapturePoints;

    // Speciális és Max értékek
    @JsonProperty("battles_on_stunning_vehicles")
    private Integer battlesOnStunningVehicles;
    @JsonProperty("max_xp")
    private Integer maxXp;
    @JsonProperty("max_frags")
    private Integer maxFrags;
    @JsonProperty("max_damage")
    private Integer maxDamage;
}
