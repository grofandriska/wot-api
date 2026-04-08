package hu.grofandriska.wotandme.api.model.player.tankstats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedTankStatDTO {

    @JsonProperty("tank_id")
    private Long tankId;
    @JsonProperty("account_id")
    private Long accountId;

    @JsonProperty("mark_of_mastery")
    private Integer markOfMastery;

    private TankAllStatsDTO all;


}
