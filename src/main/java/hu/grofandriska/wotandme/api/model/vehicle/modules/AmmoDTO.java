package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

import java.util.List;


@Data
public class AmmoDTO {
    public List<Integer> damage;
    public List<Integer> penetration;
    public String type;
    public StunDto stun;

    @Data
    public static class StunDto {
        // A hiba itt volt: az API [min, max] listát küld, nem objektumot
        public List<Float> duration;
    }
}
