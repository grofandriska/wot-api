package hu.grofandriska.wotandme.api.model.vehicle.modules;

import lombok.Data;

@Data
public class RadioDTO {
    public String name;
    public Integer signal_range;
    public String tag;
    public Integer tier;
    public Integer weight;
}
