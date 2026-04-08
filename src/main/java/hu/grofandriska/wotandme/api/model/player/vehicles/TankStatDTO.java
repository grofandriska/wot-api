package hu.grofandriska.wotandme.api.model.player.vehicles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TankStatDTO {
    @JsonProperty("tank_id")
    private Long tankId;
    @JsonProperty("mark_of_mastery")
    private Integer markOfMastery;
    private TankStatisticsDTO statistics;
}
