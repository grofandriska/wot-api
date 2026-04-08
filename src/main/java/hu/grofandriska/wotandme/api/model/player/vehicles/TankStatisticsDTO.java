package hu.grofandriska.wotandme.api.model.player.vehicles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TankStatisticsDTO {

    private Integer wins;
    private Integer battles;
}
