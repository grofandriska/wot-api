package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

@Data
public class EngineDTO {
    public Float fire_chance;
    public String name;
    public Integer power;
    public String tag;
    public Integer tier;
    public Integer weight;
}
