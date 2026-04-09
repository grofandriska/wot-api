package hu.grofandriska.wotandme.api.model.vehicle;

import hu.grofandriska.wotandme.api.model.player.personaldata.MetaDTO;
import lombok.Data;

import java.util.Map;

@Data
public class WargamingResponseDTO<T> {
    private String status;
    private MetaDTO meta;
    private Map<String, T> data; // A kulcs a tank_id Stringként, az érték a DTO-d
}
